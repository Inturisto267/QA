package core.enums;

public enum Standards {

    GOST3262_75("ГОСТ 3262-75");

    private String standard;

    Standards(String stName) {
        this.standard = stName;
    }

    public String getStandard() {
        return standard;
    }
}
