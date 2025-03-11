package cleancode.studycafe.practice.model;

public class Order {

    private final StudyCafePass studyCafePass;
    private final StudyCafeLockerPass studyCafeLockerPass;

    private Order(StudyCafePass studyCafePass, StudyCafeLockerPass studyCafeLockerPass) {
        this.studyCafePass = studyCafePass;
        this.studyCafeLockerPass = studyCafeLockerPass;
    }

    public static Order of(StudyCafePass studyCafePass, StudyCafeLockerPass studyCafeLockerPass) {
        return new Order(studyCafePass, studyCafeLockerPass);
    }

    public int getTotalPrice() {
        return studyCafePass.getPrice() - studyCafePass.getDiscountPrice() + (studyCafeLockerPass != null ? studyCafeLockerPass.getPrice() : 0);
    }

    public int getDiscountPrice() {
        return studyCafePass.getDiscountPrice();
    }

    public void display() {
        System.out.println();
        System.out.println("이용 내역");
        System.out.println("이용권: " + studyCafePass.display());
        if (studyCafeLockerPass != null) {
            System.out.println("사물함: " + studyCafeLockerPass.display());
        }
    }
}
