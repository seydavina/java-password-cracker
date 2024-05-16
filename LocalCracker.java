public abstract class LocalCracker extends PasswordCrackerFactory {
    public PasswordCracker createPasswordCracker() {
        return (PasswordCracker) this;
    }
}