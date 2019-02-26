package core;

/**
 * Retorna uma ação
 */
public class ActionLog {

    private String message;
    private double hpDamage;
    private double mpDamage;
    private double stamina;

    /**
     * Informa ao usuário as consequências de suas ações
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @return
     */
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
