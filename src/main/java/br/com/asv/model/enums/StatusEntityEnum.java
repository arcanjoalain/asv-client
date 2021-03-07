package br.com.asv.model.enums;


public enum StatusEntityEnum {
    DISABLED(0),
    ENABLED(1),
    BLOCKED(2);
    
	private final int value;
    
    public int getValue() {
    	return this.value;
    }
    
    StatusEntityEnum(int value) {
        this.value = value;
    }
}
