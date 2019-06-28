package decorator;

public class Main {
    public static void main(String[] args) {
        PizzaClass pizzaClass = new PizzaClass();
        pizzaClass.pepperoni = true;
        System.out.println(pizzaClass.getPizza());

        PizzaCheeze pizzaCheeze = new PizzaCheeze(new DoughForPizze());
        PizzaPepperoni pizzaPepperoni = new PizzaPepperoni(pizzaCheeze);
        System.out.println(pizzaPepperoni.getPizza());
    }
}
interface Pizza {
    String getPizza();
}
class PizzaWithPepperoni implements Pizza {
    @Override
    public String getPizza() {
        return "with pepperoni";
    }
}
class PizzaWithCheeze implements Pizza {
    @Override
    public String getPizza() {
        return "with cheeze";
    }
}
class PizzaWithCheezeAndPepperoni implements Pizza {
    @Override
    public String getPizza() {
        return "with pepperoni, cheeze";
    }
}

class PizzaClass implements Pizza {
    boolean pepperoni;
    boolean cheeze;

    @Override
    public String getPizza() {
        return  "with" +
                (pepperoni ? " pepperoni" : "") +
                (cheeze ? " cheeze" : "");
    }
}

class DoughForPizze implements Pizza {
    @Override
    public String getPizza() {
        return  "with";
    }
}
class PizzaPepperoni implements Pizza {

    Pizza pizza;

    public PizzaPepperoni(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getPizza() {
        return pizza.getPizza() + " pepperoni";
    }
}
class PizzaCheeze implements Pizza {

    Pizza pizza;

    public PizzaCheeze(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getPizza() {
        return pizza.getPizza() + " cheeze" ;
    }
}