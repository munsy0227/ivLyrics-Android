#!/usr/bin/env python3
import os
import re
import subprocess
import sys
from pathlib import Path


GRADLE_PATH = Path("app/build.gradle")


def parse_version(text):
    code_match = re.search(r"versionCode\s+([0-9]+)", text)
    name_match = re.search(r'versionName\s+"([^"]+)"', text)
    if code_match is None or name_match is None:
        raise ValueError("Could not read versionCode and versionName")
    return int(code_match.group(1)), name_match.group(1).strip()


def read_version():
    return parse_version(GRADLE_PATH.read_text(encoding="utf-8"))


def run_git(*args):
    return subprocess.run(
        ["git", *args],
        check=False,
        stdout=subprocess.PIPE,
        stderr=subprocess.DEVNULL,
        text=True,
    )


def previous_version_codes(current_tag):
    tags_result = run_git("tag", "--list", "v*")
    if tags_result.returncode != 0:
        return []

    versions = []
    for tag in tags_result.stdout.splitlines():
        tag = tag.strip()
        if not tag or tag == current_tag:
            continue
        gradle_result = run_git("show", f"{tag}:{GRADLE_PATH}")
        if gradle_result.returncode != 0:
            continue
        try:
            version_code, _ = parse_version(gradle_result.stdout)
        except ValueError:
            continue
        versions.append((tag, version_code))
    return versions


def main():
    release_tag = os.environ.get("RELEASE_TAG", "").strip()
    if not release_tag:
        raise ValueError("RELEASE_TAG is required")

    version_code, version_name = read_version()
    expected_tag = f"v{version_name}"
    if release_tag != expected_tag:
        raise ValueError(
            f"Release tag {release_tag!r} must equal {expected_tag!r}"
        )
    if version_code <= 0:
        raise ValueError("versionCode must be greater than zero")

    previous_versions = previous_version_codes(release_tag)
    if previous_versions:
        previous_tag, previous_code = max(
            previous_versions,
            key=lambda item: item[1],
        )
        if version_code <= previous_code:
            raise ValueError(
                f"versionCode {version_code} must be greater than "
                f"{previous_code} from {previous_tag}"
            )

    print(
        f"Verified Android release {release_tag}: "
        f"versionName={version_name}, versionCode={version_code}"
    )


if __name__ == "__main__":
    try:
        main()
    except (OSError, ValueError) as error:
        print(f"Release version validation failed: {error}", file=sys.stderr)
        raise SystemExit(1) from error
