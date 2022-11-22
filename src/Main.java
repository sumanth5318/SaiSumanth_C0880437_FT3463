import java.util.Scanner;

class ArithmeticExpression{
    int Type;
    public ArithmeticExpression(int Type){
        this.Type = Type;
    }
    public int evaluate(ArithmeticExpression term){
        return 1;
    }
}
class Number extends ArithmeticExpression{
    int value;
    public int getValue() {
        return value;
    }
    public Number(int Type,int value){
        super(Type);
        this.value = value;
    }

    @Override
    public int evaluate(ArithmeticExpression term) {
        return value;
    }
}
class Binary extends ArithmeticExpression{
    ArithmeticExpression left;
    ArithmeticExpression right;
    public Binary(int Type,int value,ArithmeticExpression left,ArithmeticExpression right){
        super(Type);
        this.left = left;
        this.right = right;
    }

    @Override
    public int evaluate(ArithmeticExpression term) {
        switch (term.Type){
            case 1:
                return 2;
            case 2:
                return evaluate(left)+evaluate(right) ;
            case 3:
                return 15;
            default:
                return 0;

        }
    }
}
class Sum extends Binary{

    public Sum(int Type, int value, ArithmeticExpression left, ArithmeticExpression right) {
        super(Type, value, left, right);
    }

    @Override
    public int evaluate(ArithmeticExpression term) {
        return super.evaluate(left)+super.evaluate(right);
    }
}
class Product extends Binary{

    public Product(int Type, int value, ArithmeticExpression left, ArithmeticExpression right) {
        super(Type, value, left, right);
    }

    @Override
    public int evaluate(ArithmeticExpression term) {
        return super.evaluate(left)*super.evaluate(right);
    }
}
class Main{
    public static void main(String [] args) {
        int TYPE_NUMBER = 1;
        int TYPE_Sum = 2;
        int TYPE_Prod = 3;
        Binary term = new Binary(TYPE_Sum, 0,
                new Binary(TYPE_NUMBER, 3, null, null),
                new Binary(TYPE_Prod, 0,
                        new Binary(1, 2, null, null),
                        new Binary(1, 5, null, null)));
        System.out.println(term.evaluate(term));
    }
}