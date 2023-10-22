public class task1_6 {
    public static class Dog {
        private String name;

        private String say;
        public void voice() {
            System.out.println("dog: " + name + ", sad: " + say);
        };
        public void setName(String name) {
            this.name = name;
        };
        public void setSay(String say) {
            this.say = say;
        }
    }


    public  static void main(String args[]) {
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();

        dog1.setName("spot");
        dog2.setName("scruffy");

        dog1.setSay("Ruff!");
        dog2.setSay("Wurf!");

        dog1.voice();
        dog2.voice();

        System.out.println("Порівнюємо за допомогою ==:");
        System.out.print(dog1 == dog2);

        System.out.println("\nПорівнюємо за допомогою equals():");
        System.out.println(dog1.equals(dog2));

        Dog anotherSpot = dog1;

        System.out.println("\nПорівнюємо нове посилання зі dog1 за допомогою ==:");
        System.out.print(anotherSpot == dog1);

        System.out.println("\nПорівнюємо нове посилання зі dog1 за допомогою equals():");
        System.out.print(anotherSpot.equals(dog1));
    }



}