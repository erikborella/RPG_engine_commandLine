package core;

/**
 * Informção sobre suas ações
 */
public class ActionLog {

    private String message;
    private double hpDamage;
    private double mpDamage;
    private double stamina;

    /**
     * Breve mensagem sobre sua ação
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * Retorna quanto hp foi perdido
     * @return
     */
    public double getHpDamage() {
        return hpDamage;
    }

    /**
     * Retorna quanto mp foi perdido
     * @return
     */
    public double getMpDamage() {
        return mpDamage;
    }

    /**
     * Retorna quanta stamina foi perdida
     * @return
     */
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
