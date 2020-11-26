package core.enums;

public enum Manufacturers {

        CT3("СТЗ"),
        TAGMET("ТАГМЕТ");

        private String name;

        Manufacturers(String manName) {
            this.name = manName;
        }

        public String getName() {
            return name;
        }
    }

