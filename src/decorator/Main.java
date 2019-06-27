package decorator;

public class Main {
    public static void main(String[] args) {
        PizzaClass pizzaClass = new PizzaClass();
        pizzaClass.paperoni = true;
        System.out.println(pizzaClass.getPizza());

        PizzaCheeze pizzaCheeze = new PizzaCheeze(new DoughForPizze());
        PizzaPaperoni pizzaPaperoni = new PizzaPaperoni(pizzaCheeze);
        System.out.println(pizzaPaperoni.getPizza());
    }
}
interface Pizza {
    String getPizza();
}
class PizzaWithPaperoni implements Pizza {
    @Override
    public String getPizza() {
        return "with paperoni";
    }
}
class PizzaWithCheeze implements Pizza {
    @Override
    public String getPizza() {
        return "with cheeze";
    }
}
class PizzaWithCheezeAndPaperoni implements Pizza {
    @Override
    public String getPizza() {
        return "with paperoni, cheeze";
    }
}

class PizzaClass implements Pizza {
    boolean paperoni;
    boolean cheeze;

    @Override
    public String getPizza() {
        return  "with" +
                (paperoni ? " paperoni" : "") +
                (cheeze ? " cheeze" : "");
    }
}

class DoughForPizze implements Pizza {
    @Override
    public String getPizza() {
        return  "with";
    }
}
class PizzaPaperoni implements Pizza {

    Pizza pizza;

    public PizzaPaperoni(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getPizza() {
        return pizza.getPizza() + " paperoni";
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