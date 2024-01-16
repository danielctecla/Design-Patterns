/* Interface for payment methods */
interface PaymentMethod {
    void processPayment();
}

/* Concrete implementations of the PaymentMethod interface */
class CreditCardPayment implements PaymentMethod {
    public void processPayment() {
        System.out.println("Processing payment using a credit card.");
    }
}

class PayPalPayment implements PaymentMethod {
    public void processPayment() {
        System.out.println("Processing payment using PayPal.");
    }
}

/* Abstract interface for creating payment method factories */
interface PaymentMethodFactory {
    PaymentMethod createPaymentMethod();
}

/* Concrete implementations of the PaymentMethodFactory interface for credit card payments */
class CreditCardPaymentFactory implements PaymentMethodFactory {
    public PaymentMethod createPaymentMethod() {
        return new CreditCardPayment();
    }
}

/* Concrete implementations of the PaymentMethodFactory interface for PayPal payments */
class PayPalPaymentFactory implements PaymentMethodFactory {
    public PaymentMethod createPaymentMethod() {
        return new PayPalPayment();
    }
}

public class Factory_Method {
    public static void main(String[] args) {
        PaymentMethodFactory creditCardFactory = new CreditCardPaymentFactory();

        PaymentMethod creditCardPayment = creditCardFactory.createPaymentMethod();

        creditCardPayment.processPayment();

        System.out.println();

        PaymentMethodFactory paypalFactory = new PayPalPaymentFactory();

        PaymentMethod paypalPayment = paypalFactory.createPaymentMethod();

        paypalPayment.processPayment();
    }
}
