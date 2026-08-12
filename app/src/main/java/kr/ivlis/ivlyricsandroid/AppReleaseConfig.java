package kr.ivlis.ivlyricsandroid;

final class AppReleaseConfig {
    static final String GITHUB_REPOSITORY = "munsy0227/ivLyrics-Android";
    static final String RELEASES_URL =
            "https://github.com/" + GITHUB_REPOSITORY + "/releases";
    static final String LATEST_RELEASE_API_URL =
            "https://api.github.com/repos/" + GITHUB_REPOSITORY + "/releases/latest";
    static final String RELEASE_DOWNLOAD_PATH_PREFIX =
            "/" + GITHUB_REPOSITORY + "/releases/download/";

    private AppReleaseConfig() {
    }
}
