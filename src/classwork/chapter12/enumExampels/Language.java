package classwork.chapter12.enumExampels;

public enum Language {
    ARM("Армянский"), RUS("Русский"), ENG("Англиский");
    private String languageName;
    Language(String languageName) {
        this.languageName = languageName;
    }
    Language() {
    }
    public String getLanguageName() {
        return languageName;
    }
}
