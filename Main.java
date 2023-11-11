package task5_18;

// Клас кнопки
class Button {
    private String note;

    public Button(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void press() {
        System.out.println("Note played: " + note);
    }
}

// Клас педалі
class Pedal {
    public void press() {
        System.out.println("Pedal pressed");
    }
}

// Клас піаніно
class Piano {
    private Button[] buttons;
    private Pedal pedal;

    public Piano(int numberOfKeys) {
        buttons = new Button[numberOfKeys];
        for (int i = 0; i < numberOfKeys; i++) {
            buttons[i] = new Button("Key " + (i + 1));
        }
        pedal = new Pedal();
    }

    public void tune() {
        System.out.println("Piano tuned");
    }

    public void play() {
        System.out.println("Playing the piano...");
        for (Button button : buttons) {
            button.press();
        }
        pedal.press();
    }

    public void pressKey(int keyNumber) {
        if (keyNumber >= 1 && keyNumber <= buttons.length) {
            buttons[keyNumber - 1].press();
        } else {
            System.out.println("Invalid key number");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Створення об'єкта піаніно з 5 клавішами
        Piano piano = new Piano(5);

        // Настроюємо піаніно
        piano.tune();

        // Граємо на піаніно
        piano.play();

        // Натискання на конкретну клавішу
        piano.pressKey(3);
    }
}
