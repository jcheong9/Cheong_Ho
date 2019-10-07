package ca.bcit.cheong_ho.models;

import ca.bcit.cheong_ho.enums.ISBNType;

class ISBN {
    private ISBNType type;
    private String identifier;

    public ISBN(ISBNType type, String identifier) {
        this.type = type;
        this.identifier = identifier;
    }

    public ISBNType getType() {
        return type;
    }

    public void setType(ISBNType type) {
        this.type = type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String newIdentifier) {
        this.identifier = newIdentifier;
    }
}
