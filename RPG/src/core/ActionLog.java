package core;

public class ActionLog {

    private String message;
    private double hpDamage;
    private double mpDamage;
    private double stamina;

    public String getMessage() {
        return message;
    }

    public double getHpDamage() {
        return hpDamage;
    }

    public double getMpDamage() {
        return mpDamage;
    }

    public double getStamina() {
        return stamina;
    }

    public ActionLog(String message, double hpDamage, double mpDamage, double stamina) {
        this.message = message;
        this.hpDamage = hpDamage;
        this.mpDamage = mpDamage;
        this.stamina = stamina;
    }
}
