package main.java.com.faijanshaikh.solidDesignPrinciples;

public class Dependency_Inversion_Principle_DIP {
    /*
        The rule of Dependency inversion principle(DIP) is High level modules should not depends on low level modules
        the class should implement interface or, abstractions not on concreate classes
     */

    public static void main(String[] args) {
        Notification notification = new Notification(new EmailService());
        notification.send("Hi faizan");

        Notification1 notification1 = new Notification1(new EmailService1());
        notification1.send("Hi Afreen");
    }

}

//-------------Example1 violating DIP------------------
class EmailService {
    public void sendEmail(String message) {
        System.out.println("email sent :" + message);
    }
}

class Notification {
    private EmailService emailService;

    public Notification(EmailService emailService) {
        this.emailService = emailService;
    }

    public void send(String message) {
        emailService.sendEmail(message);
    }
}

//----------------Example2 following rule with DIP----------

interface Service {
    void send(String message);
}

class EmailService1 implements Service {
    @Override
    public void send(String message) {
        System.out.println("email sent :" + message);
    }
}

class Notification1 {
    private Service service;

    Notification1 (Service service) {
        this.service = service;
    }

    public void send(String message){
        service.send(message);
    }

}