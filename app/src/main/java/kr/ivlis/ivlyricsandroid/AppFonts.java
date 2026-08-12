package kr.ivlis.ivlyricsandroid;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;
import java.util.Map;

final class AppFonts {
    private static final String FONT_ASSET_PATH = "fonts/NotoSerifCJK-VF.ttf.ttc";
    private static final int KOREAN_TTC_INDEX = 1;
    private static final int REGULAR_WEIGHT = 400;
    private static final int SEMI_BOLD_WEIGHT = 600;
    private static final int BOLD_WEIGHT = 700;
    private static final int MIN_FONT_WEIGHT = 200;
    private static final int MAX_FONT_WEIGHT = 900;
    private static final Map<Integer, Typeface> WEIGHT_CACHE = new HashMap<>();

    private AppFonts() {
    }

    static Typeface regular(Context context) {
        return load(context, REGULAR_WEIGHT, Typeface.NORMAL);
    }

    static Typeface semiBold(Context context) {
        return load(context, SEMI_BOLD_WEIGHT, Typeface.BOLD);
    }

    static Typeface bold(Context context) {
        return load(context, BOLD_WEIGHT, Typeface.BOLD);
    }

    static Typeface byWeight(Context context, String weight) {
        String normalized = AiLyricsSettings.normalizeTypographyWeight(weight);
        if (AiLyricsSettings.TYPO_WEIGHT_REGULAR.equals(normalized)) {
            return regular(context);
        }
        if (AiLyricsSettings.TYPO_WEIGHT_BOLD.equals(normalized)) {
            return bold(context);
        }
        return semiBold(context);
    }

    static Typeface cultural(Context context, String family, int weight) {
        String normalizedFamily = AiLyricsSettings.normalizeCulturalFontFamily(family);
        int normalizedWeight = AiLyricsSettings.normalizeCulturalFontWeight(weight);
        Typeface base;
        if (AiLyricsSettings.CULTURAL_FONT_SERIF.equals(normalizedFamily)) {
            base = Typeface.SERIF;
        } else if (AiLyricsSettings.CULTURAL_FONT_MONOSPACE.equals(normalizedFamily)) {
            base = Typeface.MONOSPACE;
        } else if (AiLyricsSettings.CULTURAL_FONT_SYSTEM.equals(normalizedFamily)) {
            base = Typeface.DEFAULT;
        } else {
            return load(
                    context,
                    normalizedWeight,
                    normalizedWeight >= SEMI_BOLD_WEIGHT ? Typeface.BOLD : Typeface.NORMAL
            );
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
            return Typeface.create(base, normalizedWeight, false);
        }
        return Typeface.create(base, weight >= 600 ? Typeface.BOLD : Typeface.NORMAL);
    }

    private static Typeface load(Context context, int weight, int fallbackStyle) {
        int normalizedWeight = Math.max(MIN_FONT_WEIGHT, Math.min(MAX_FONT_WEIGHT, weight));
        synchronized (WEIGHT_CACHE) {
            Typeface cached = WEIGHT_CACHE.get(normalizedWeight);
            if (cached != null) {
                return cached;
            }
            Typeface loaded = build(context, normalizedWeight, fallbackStyle);
            WEIGHT_CACHE.put(normalizedWeight, loaded);
            return loaded;
        }
    }

    private static Typeface build(Context context, int weight, int fallbackStyle) {
        try {
            Typeface typeface = new Typeface.Builder(context.getAssets(), FONT_ASSET_PATH)
                    .setTtcIndex(KOREAN_TTC_INDEX)
                    .setFontVariationSettings("'wght' " + weight)
                    .setWeight(weight)
                    .setItalic(false)
                    .build();
            if (typeface != null) {
                return typeface;
            }
        } catch (Exception ignored) {
        }
        return Typeface.create("serif", fallbackStyle);
    }
}
