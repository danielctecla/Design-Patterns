import java.util.ArrayList;
import java.util.List;

abstract class Wallet {
    public abstract float getBalance();
}

class DepositWallet extends Wallet {
    private String addressWallet;
    private float walletBalance;

    public DepositWallet(String addressWallet, float walletBalance) {
        super();
        this.addressWallet = addressWallet;
        this.walletBalance = walletBalance;
    }

    public float getBalance() {
        return walletBalance;
    }

}

class SavingWallet extends Wallet {
    private String addressWallet;
    private float walletBalance;

    public SavingWallet(String addressWallet, float walletBalance) {
        super();
        this.addressWallet = addressWallet;
        this.walletBalance = walletBalance;
    }

    public float getBalance() {
        return walletBalance;
    }
}

class CompositeWallet extends Wallet {
    private float totalBalance;
    private List<Wallet> wallets = new ArrayList<Wallet>();

    public void addWallet(Wallet wallet) {
        wallets.add(wallet);
    }

    public float getBalance() {
        totalBalance = 0;
        for (Wallet wallet : wallets) {
            totalBalance += wallet.getBalance();
        }
        return totalBalance;
    }

    public void addWallets(Wallet wallet) {
        this.wallets.add(wallet);
    }

    public void removeWallet(Wallet wallet) {
        this.wallets.remove(wallet);
    }
}

public class Composite {
    
    public static void main(String[] args) {
        CompositeWallet component = new CompositeWallet();

        component.addWallet(new DepositWallet("0x123456789", 100));
        component.addWallet(new DepositWallet("0x123456789", 200));
        component.addWallet(new SavingWallet("0x912345124", 300));

        float totalBalance = component.getBalance();
        System.out.println("Total balance: " + totalBalance);
    }

    
}