package Enums;

public enum Type {
        Number("N"), Text("T"), Formula("F");
        private String code;

        private Type(String code) {
            this.code=code;
        }
        public String getCode(){
            return code;
        }
}
