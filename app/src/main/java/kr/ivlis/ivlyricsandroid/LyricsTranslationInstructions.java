package kr.ivlis.ivlyricsandroid;

final class LyricsTranslationInstructions {
    static final String TEXT = """
            # Lyrics Translation Instructions

            Use surrounding lines to determine context, speaker intent, relationships, references, implied meaning, and ambiguity, but use that context only to interpret the current line. Do not import information, words, grammatical elements, or meaning from other lines into it.

            ## 1. Strict Line Correspondence

            Maintain strict one-to-one line correspondence.

            Translate each line independently so that:

            * line 1 corresponds strictly to line 1,
            * line 2 corresponds strictly to line 2,
            * and so on.

            Never:

            * merge multiple source lines into one translated line,
            * split one source line across several translated lines,
            * move information from one line into another,
            * complete one line using words or meaning that appear only in surrounding lines.

            Context may help determine what the current line means, but it must never be used to redistribute meaning across line boundaries.

            ## 2. Output Format

            Provide exactly one definitive translation for each source line.

            Do not provide:

            * multiple translations,
            * alternative choices,
            * candidate phrasings,
            * "Option A / Option B",
            * explanations,
            * translator's notes,
            * pronunciation guides,
            * romanization,
            * annotations,
            * labels,
            * commentary,
            * conversational filler.

            Output only the finalized translated lyric lines, preserving the exact line structure of the source.

            ## 3. Preserve Meaning Without Adding or Removing Information

            Preserve the meaning of the current line as precisely as possible.

            Never:

            * add new meaning,
            * omit meaningful information,
            * explain what the original merely implies,
            * strengthen or weaken the speaker without reason,
            * resolve intentional ambiguity without sufficient evidence,
            * transfer meaning from one lyric line into another.

            Do not paraphrase merely because a freer expression sounds smoother.

            Use the smallest amount of reinterpretation necessary for the line to function correctly in the target language.

            ## 4. Preserve Information Order and Delayed Revelation

            Preserve the order in which information, images, emotions, actions, objects, causes, destinations, conclusions, and revelations are introduced within each line as closely as the target language permits.

            The timing of information in lyrics can carry dramatic, emotional, rhythmic, or rhetorical importance.

            Do not automatically reorganize a lyric into ordinary prose order.

            In particular, do not front-load information that the source intentionally delays toward the end of the line.

            ### Example

            Source:

            > 달려 나갔어, 비 내리는 밤으로

            Prefer:

            > 달려 나갔어, 비 내리는 밤으로

            Avoid unnecessarily flattening it into:

            > 비 내리는 밤으로 달려 나갔어

            If an action appears first and its destination, object, cause, emotional meaning, or revelation appears only later, preserve that delayed progression whenever target-language grammar permits.

            ## 5. Preserve Syntax When Meaningful, Not Mechanically

            Preserve the source word order and syntactic sequence when they remain:

            * grammatical,
            * natural,
            * intentionally unusual,
            * poetically marked,
            * rhetorically meaningful

            in the target language.

            However, do not mechanically reproduce source-language syntax when doing so creates awkwardness that exists only because of source-language interference.

            The priority is to preserve **how the line unfolds**, not to reproduce every source-language grammatical position mechanically.

            If the original itself is unusual, preserve comparable unusualness.

            If the original is natural but literal syntax would make the translation accidentally broken, adjust only what is necessary.

            ## 6. Preserve Lexical Identity and Conceptual Vocabulary

            Preserve not only the broad meaning of a word, but also the specific conceptual vocabulary chosen by the lyricist.

            A nearby synonym is not automatically equivalent.

            When several target-language expressions could communicate approximately the same situation, prefer the expression that best preserves:

            * the source word's lexical meaning,
            * conceptual structure,
            * level of abstraction,
            * emotional force,
            * register,
            * stylistic markedness.

            Do not replace the lyricist's chosen vocabulary merely because another word is:

            * more common,
            * smoother,
            * more conversational,
            * more elegant,
            * more emotionally obvious.

            ### Example

            Preserve:

            > 붕괴하는 기대

            rather than automatically simplifying it to:

            > 무너지는 기대

            Preserve:

            > 증대하는 불안

            rather than automatically changing it to:

            > 커져가는 불안

            Preserve:

            > 갈망

            rather than automatically replacing it with:

            > 바람
            > 원함

            Preserve:

            > 상실

            rather than automatically replacing it with:

            > 잃어버림

            ## 7. Preserve Lexical Tier and Register

            Preserve the closest equivalent:

            * lexical tier,
            * conceptual density,
            * formal register,
            * literary register,
            * technical register,
            * abstract register,
            * archaic register,
            * intellectual texture

            of the source vocabulary.

            When the source deliberately uses conceptually heavy, literary, technical, formal, Sino-derived, archaic, academic, or otherwise marked vocabulary, prefer a comparably marked target-language expression.

            Do not "purify" or simplify formal or conceptual vocabulary into casual descriptive wording merely to improve conversational naturalness.

            However, do not preserve etymology mechanically when the corresponding target-language expression would change the actual meaning or register.

            Preserve the **semantic and stylistic weight** of the lexical choice, not merely its historical origin.

            ## 8. Japanese Kanji: Treat Kanji Choice as Lexical Information

            When the source language is Japanese, do not determine meaning from kanji characters alone.

            For every Japanese expression written with kanji, consider:

            1. the actual Japanese lexical item,
            2. its intended reading,
            3. its grammatical function,
            4. whether the reading is on'yomi, kun'yomi, jukujikun, ateji, or another special reading,
            5. its conventional Japanese meaning in context,
            6. the semantic contribution of the chosen kanji,
            7. its lexical register and emotional texture,
            8. whether the target language has a direct or closely corresponding Sino-derived cognate.

            The written kanji, the actual word being pronounced, and the conventional lexical meaning must all be considered.

            ## 9. Japanese On'yomi and Sino-Japanese Compounds

            When a Japanese expression is an on'yomi-based Sino-Japanese compound, preserve its underlying kanji concept as closely as possible.

            If the target language has an established Sino-derived cognate that directly corresponds to the same kanji concept, strongly prefer that cognate unless doing so would be:

            * semantically incorrect,
            * grammatically impossible,
            * genuinely unintelligible,
            * clearly misleading in the specific context.

            Do not replace one kanji concept with another neighboring concept merely because the replacement sounds more idiomatic.

            ### Example

            `最低` and `最悪` are not lexically identical.

            If the source says:

            > 最低

            do not automatically translate it using a target-language term conceptually corresponding to:

            > 最悪

            merely because that wording is more common in everyday speech.

            The fact that two expressions can describe a similarly negative situation does not erase the lyricist's lexical distinction.

            Likewise:

            * `崩壊` should preferentially retain a concept corresponding to **붕괴**, rather than automatically becoming **무너짐**.
            * `増大` should preferentially retain a concept corresponding to **증대**, rather than automatically becoming **커짐**.
            * `喪失` should not automatically be treated as though the source merely said `失う`.

            Naturalness alone is not sufficient reason to replace the original kanji concept.

            ## 10. Do Not Substitute Neighboring Kanji Concepts

            Distinguish words that are close in practical meaning but are lexically different.

            Do not automatically translate:

            * `最低` as though the source had said `最悪`,
            * `希望` as though the source had said `願い`,
            * `喪失` as though the source had simply said `失う`,
            * `増大` as though the source had simply said `大きくなる`,
            * `崩壊` as though the source had simply said `崩れる`.

            A synonym is not automatically an equivalent translation when it changes the conceptual vocabulary deliberately chosen by the lyricist.

            When a direct same-kanji or equivalent-kanji target-language cognate sounds somewhat literary, stiff, formal, or marked, that alone is **not** sufficient reason to replace it.

            Markedness may itself be part of the lyric.

            ## 11. Japanese Kun'yomi and Native Japanese Lexemes

            Do not mechanically convert every Japanese kanji into a Sino-derived target-language word.

            When kanji are used to represent a native Japanese lexeme through kun'yomi, translate the actual Japanese word represented by the reading.

            The meaning of the isolated kanji character must not override the lexical identity of the native Japanese word.

            ### Example

            `想い（おもい）` represents the lexical item `おもい`.

            Do not automatically force a formal Sino-derived translation merely because it is written with `想`.

            Interpret:

            * what `おもい` means in the specific context,
            * what emotional or literary nuance the spelling `想い` adds,
            * and how both can best be reflected in the target language.

            Likewise, expressions such as:

            > いのち

            and:

            > 生命

            may both relate broadly to "life", but they do not necessarily carry the same register, emotional texture, conceptual abstraction, or lyrical effect.

            Preserve the distinction created by the actual lexical choice.

            ### General Rule

            For an **on'yomi / Sino-Japanese compound**:

            > kanji identity and corresponding Sino-derived vocabulary receive strong preservation priority.

            For a **kun'yomi / native Japanese lexeme**:

            > the actual Japanese word represented by the reading receives primary lexical priority, while the chosen kanji may contribute additional nuance.

            Reading type is evidence about lexical identity and register. It is not a mechanical rule that determines whether the target translation must use a native or Sino-derived word.

            ## 12. Furigana and Deliberate Reading–Writing Differences

            When furigana or another explicit reading is provided, treat it as essential linguistic information.

            Do not treat furigana merely as pronunciation assistance.

            Determine whether:

            * it simply gives the ordinary reading,
            * it identifies which lexical sense is intended,
            * it creates a deliberate contrast with the written kanji,
            * or the written form and pronounced form create two simultaneous semantic layers.

            If the written kanji and the pronounced reading deliberately differ, do not discard either layer automatically.

            The pronounced reading represents what the listener hears.

            The written kanji may simultaneously contribute:

            * an additional concept,
            * metaphor,
            * visual association,
            * symbolic layer,
            * emotional implication,
            * double meaning.

            Preserve as much of both layers as a single natural translated line reasonably permits.

            If both layers cannot be fully represented simultaneously without adding explanations or making the line unnaturally explicit, prioritize the lexical meaning actually being pronounced while retaining the written-form nuance when possible.

            Do not add translator's notes to explain the double meaning.

            ## 13. Do Not Infer Japanese Readings from Kanji Alone

            If a Japanese kanji sequence has multiple possible readings, do not choose a meaning solely by mechanically interpreting its characters.

            Use:

            * furigana,
            * grammatical structure,
            * surrounding context,
            * collocation,
            * established Japanese usage,
            * lyrical usage,
            * actual pronunciation when provided

            to identify the intended lexical item.

            Do not assume:

            > kanji appearance = lexical meaning

            without considering the actual reading and usage.

            ## 14. Preserve Rhetorical Form and Fragments

            Preserve:

            * fragments,
            * noun endings,
            * ellipsis,
            * incomplete syntax,
            * nominal expressions,
            * intentional irregularity,
            * questions,
            * exclamations,
            * abrupt cutoffs,
            * unusual constructions.

            Do not unnecessarily turn fragments into complete sentences.

            ### Example

            Source:

            > 새벽녘의 기억...

            Preserve:

            > 새벽녘의 기억...

            Do not expand it into:

            > 그것은 새벽녘의 기억이다.

            ### Example

            Source:

            > 왜일까

            Preserve:

            > 왜일까

            Do not unnecessarily expand it into:

            > 그것은 왜 그런 것일까?

            Do not turn an indirect expression into an explicit statement merely to clarify it.

            ## 15. Preserve Omission

            Do not supply omitted information unless the target language grammatically requires it and the context establishes it with sufficient certainty.

            Do not unnecessarily insert:

            * subjects,
            * objects,
            * pronouns,
            * gender,
            * number,
            * relationships,
            * agents,
            * recipients,
            * causes,
            * ownership,
            * emotional explanations.

            ### Example

            Source:

            > 바라보고 있었어

            If the source does not explicitly state who is looking at whom, preserve the omission whenever possible:

            > 바라보고 있었어

            Do not arbitrarily expand it into:

            > 나는 너를 바라보고 있었어

            merely because context makes that interpretation plausible.

            Context may be used to understand a line, but not as permission to make implicit information explicit.

            ## 16. Preserve Ambiguity

            If multiple interpretations remain genuinely possible after considering the available context, preserve that ambiguity whenever the target language permits.

            Do not make an ambiguous line more specific merely because one interpretation seems more likely.

            Do not resolve ambiguity simply to make the translation easier to understand.

            Intentional ambiguity is part of the source meaning.

            ## 17. Preserve Speaker Stance and Pragmatic Force

            Preserve the speaker's mode of expression, including:

            * tense,
            * aspect,
            * modality,
            * certainty,
            * uncertainty,
            * conjecture,
            * wishes,
            * commands,
            * requests,
            * questions,
            * exclamations,
            * politeness,
            * roughness,
            * intimacy,
            * emotional distance,
            * benefactive nuance,
            * relational nuance,
            * sentence-ending force.

            Do not replace a marked construction with a more ordinary one merely because the ordinary construction is more common.

            ### Example Principles

            A tentative statement should remain tentative.

            A reluctant command should not become a forceful command.

            A rough expression should not automatically become polite.

            An intimate ending should not become emotionally neutral.

            A possibility should not become a certainty.

            ## 18. Preserve Strength and Certainty

            Do not strengthen or weaken:

            * emotion,
            * affection,
            * hostility,
            * vulgarity,
            * politeness,
            * intimacy,
            * agency,
            * obligation,
            * possibility,
            * probability,
            * negation,
            * emphasis,
            * desperation,
            * certainty.

            ### Example Principles

            `might` must not automatically become `will`.

            A mild insult must not become a severe insult.

            A strong declaration must not be softened into a vague suggestion.

            A weak possibility must not become a confident conclusion.

            ## 19. Preserve Lyrical Markedness

            Preserve the markedness and lyrical density of the original.

            If the source sounds:

            * poetic,
            * lyrical,
            * old-fashioned,
            * archaic,
            * childlike,
            * playful,
            * theatrical,
            * dramatic,
            * wistful,
            * blunt,
            * rough,
            * stiff,
            * formal,
            * intimate,
            * fragmented,
            * obsessive,
            * narrative,
            * deliberately strange,

            choose target-language phrasing that naturally carries a comparable effect.

            "Natural" means natural for the song's:

            * speaker,
            * context,
            * genre,
            * era,
            * emotional state,
            * lyrical style.

            It does **not** mean automatically flattening poetic, formal, stiff, strange, or literary language into casual everyday conversation.

            ## 20. Naturalness Must Not Erase Intentional Markedness

            The translated line should read as intentional target-language lyrics rather than as a mechanical gloss.

            However:

            > naturalness must not override lexical identity, poetic structure, or deliberate strangeness.

            If the source itself is strange, preserve comparable strangeness.

            If the source itself is formal, preserve comparable formality.

            If the source itself is stiff, preserve comparable stiffness.

            If the source is natural but a literal translation becomes accidentally unnatural only because of source-language interference, adjust only what is necessary.

            Do not "improve" an unusual source into ordinary prose.

            ## 21. Preserve Compactness and Breath Units

            Do not bloat short or dense lyric lines with explanatory wording.

            Preserve:

            * concision,
            * density,
            * breath units,
            * rhythmic compactness,
            * abruptness,
            * short emotional punches

            whenever possible.

            Do not add words solely to make implicit meaning more explicit.

            A short line should not become a long explanatory sentence unless the target language genuinely requires it.

            ## 22. Preserve Repetition and Parallelism

            Preserve deliberate repetition exactly when meaningful.

            When the source repeats the same:

            * word,
            * phrase,
            * grammatical construction,
            * sentence ending,
            * refrain,
            * hook,
            * rhythmic expression,

            preserve that repetition consistently.

            Do not introduce synonyms merely to create stylistic variety.

            ### Example

            If the source repeats the equivalent of:

            > 모두 모두 모두

            preserve:

            > 모두 모두 모두

            rather than changing it to:

            > 모두 전부 다

            Do not treat repetition as stylistic redundancy that should be "fixed".

            ## 23. Preserve Recurring Key Vocabulary

            Recurring:

            * key words,
            * images,
            * motifs,
            * metaphors,
            * hooks,
            * refrains

            should normally receive consistent translations throughout the song.

            Do not vary the translation merely for stylistic diversity.

            Change the translation only when the context clearly changes the word's:

            * meaning,
            * grammatical function,
            * connotation,
            * rhetorical role.

            For Japanese lyrics, however, distinguish whether repeated kanji actually represent the same lexical item and reading before forcing consistency.

            The same kanji with a different reading or lexical function may require a different translation.

            Conversely, the same lexical item should remain consistently translated when its meaning and function remain unchanged, even if orthographic presentation varies.

            ## 24. Preserve Imagery and Figurative Language

            Preserve:

            * metaphors,
            * symbols,
            * poetic imagery,
            * personification,
            * figurative expressions

            whenever they remain understandable in the target language.

            Do not replace imagery with explanatory paraphrase merely to clarify what it "really means".

            ### Example

            If the source says that a heart:

            > freezes

            preserve the image of freezing if it remains intelligible.

            Do not automatically explain it as:

            > losing emotion

            The metaphor itself is meaningful information.

            ## 25. Idioms and Language-Specific Expressions

            When a literal translation of an idiom or fixed expression would become:

            * misleading,
            * semantically incorrect,
            * unintelligible,
            * unintentionally absurd,

            use a natural target-language expression that preserves the original:

            * meaning,
            * tone,
            * force,
            * rhetorical function.

            Do not preserve surface wording at the cost of the actual expression.

            However, do not treat an unusual but intelligible metaphor as an idiom merely to justify paraphrasing it.

            ## 26. Preserve Cultural References

            Do not unnecessarily domesticate:

            * names,
            * titles,
            * objects,
            * places,
            * foods,
            * customs,
            * religious references,
            * historical references,
            * cultural symbols,
            * culturally specific imagery.

            Preserve them when they are meaningful to the song rather than replacing them with more familiar target-culture equivalents merely for convenience.

            ## 27. Distinguish Lexical Language from Non-Lexical Vocalization

            When a sequence functions primarily as:

            * a sung sound,
            * vocalization,
            * cry,
            * chant,
            * interjection,
            * breath,
            * exclamation,
            * sound effect

            rather than as a lexical expression, preserve its audible form and musical or expressive function.

            Do not translate such vocalizations according to dictionary meaning.

            Render them using the target language's most natural phonetic representation based on how they are actually pronounced.

            Do **not** mechanically transliterate written characters one by one.

            Preserve meaningful differences in:

            * vowel quality,
            * consonants,
            * syllable shape,
            * lengthening,
            * repetition,
            * rhythm,
            * stress,
            * audible timing.

            ### Example

            If a sung vocalization is actually pronounced approximately as:

            > 앙 앙 앙

            render it according to that audible pronunciation.

            Do not mechanically convert its written symbols into:

            > 안 안 안

            if that does not reflect the sound actually being sung.

            ### Example

            An elongated vocalization such as:

            > Ah—

            should remain an elongated sung sound.

            Do not convert it into semantic prose such as:

            > a cry of pain

            unless the sequence is genuinely functioning as lexical language.

            ## 28. Vocalization vs. Lexical Meaning

            Do not assume that unusual spelling, katakana, repeated syllables, or phonetic-looking text is automatically non-lexical.

            Determine whether the expression primarily functions through:

            * semantic meaning,
            * sung sound,
            * or both.

            If it genuinely functions as a lexical word or phrase, translate its meaning.

            If it primarily functions as a vocalization, preserve its audible form.

            For ambiguous cases, use:

            * immediate context,
            * actual pronunciation,
            * grammatical role,
            * musical function

            to determine which function is primary.

            ## 29. Minimum-Change Principle

            Make the smallest lexical, grammatical, and structural changes necessary to create a valid target-language lyric.

            For Japanese kanji vocabulary, preserve in order of preference:

            1. the actual lexical meaning in context,
            2. the specific conceptual vocabulary chosen by the source,
            3. the lexical identity implied by the reading,
            4. the semantic contribution of the chosen kanji,
            5. a direct same-kanji or equivalent-kanji target-language cognate when viable,
            6. the original level of abstraction and register,
            7. the original strength and evaluative force.

            Only move to a neighboring synonym or different conceptual vocabulary when preserving the original choice would create a genuine semantic error or make the expression nonfunctional in the target language.

            A merely smoother alternative is not sufficient justification.

            ## 30. Conflict Resolution Priority

            When two instructions appear to conflict, follow this priority:

            1. **Preserve the lexical meaning, specific conceptual vocabulary, and pragmatic force of the current line.**
            2. **For Japanese, preserve the distinction created by the actual lexical item, reading, and author-selected kanji whenever semantically viable.**
            3. **Preserve strict one-to-one line correspondence and prevent meaning from crossing line boundaries.**
            4. **Preserve ambiguity, omission, rhetorical form, and intentional irregularity.**
            5. **Preserve the progression and timing of information within the line.**
            6. **Preserve lexical register, conceptual density, imagery, repetition, and stylistic markedness.**
            7. **Preserve source syntax and word order when meaningful and viable.**
            8. **Make only the minimum grammatical adjustments necessary for the translation to function naturally in the target language.**

            Do not sacrifice lexical identity, meaning, ambiguity, or stylistic intent merely to make the translation smoother.

            Conversely, do not reproduce source-language structure so mechanically that the translation becomes accidentally ungrammatical or semantically distorted.

            ## 31. Final Translation Standard

            The final translation must preserve, as faithfully as the target language permits:

            * the meaning of each individual line,
            * strict line correspondence,
            * lexical identity,
            * specific conceptual vocabulary,
            * Japanese kanji distinctions where relevant,
            * intended readings,
            * ambiguity,
            * omission,
            * information order,
            * delayed revelations,
            * grammatical and rhetorical form,
            * lexical register,
            * conceptual density,
            * emotional force,
            * tense and modality,
            * imagery,
            * metaphor,
            * repetition,
            * parallelism,
            * cultural references,
            * vocalizations,
            * lyrical character.

            The translation should sound like intentional lyrics in the target language, but **naturalness must never be used as an excuse to replace the lyricist's specific lexical choices, conceptual distinctions, poetic structures, or deliberate irregularities with easier neighboring expressions.**

            """;

    private LyricsTranslationInstructions() {
    }
}
