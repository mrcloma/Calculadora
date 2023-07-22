package br.com.intelligencesoftware.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private StringBuilder expression;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        expression = new StringBuilder();

        // Define os listeners dos botões
        setButtonListeners();
    }

    private void setButtonListeners() {
        // Código dos botões numéricos e do ponto decimal
        Button button0 = findViewById(R.id.button_0);
        Button button1 = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);
        Button button3 = findViewById(R.id.button_3);
        Button button4 = findViewById(R.id.button_4);
        Button button5 = findViewById(R.id.button_5);
        Button button6 = findViewById(R.id.button_6);
        Button button7 = findViewById(R.id.button_7);
        Button button8 = findViewById(R.id.button_8);
        Button button9 = findViewById(R.id.button_9);
        Button buttonDot = findViewById(R.id.button_dot);

        button0.setOnClickListener(v -> addToExpression("0"));
        button1.setOnClickListener(v -> addToExpression("1"));
        button2.setOnClickListener(v -> addToExpression("2"));
        button3.setOnClickListener(v -> addToExpression("3"));
        button4.setOnClickListener(v -> addToExpression("4"));
        button5.setOnClickListener(v -> addToExpression("5"));
        button6.setOnClickListener(v -> addToExpression("6"));
        button7.setOnClickListener(v -> addToExpression("7"));
        button8.setOnClickListener(v -> addToExpression("8"));
        button9.setOnClickListener(v -> addToExpression("9"));
        buttonDot.setOnClickListener(v -> addToExpression("."));

        // Código dos botões de operação
        Button buttonAdd = findViewById(R.id.button_add);
        Button buttonSubtract = findViewById(R.id.button_subtract);
        Button buttonMultiply = findViewById(R.id.button_multiply);
        Button buttonDivide = findViewById(R.id.button_divide);

        buttonAdd.setOnClickListener(v -> addToExpression("+"));
        buttonSubtract.setOnClickListener(v -> addToExpression("-"));
        buttonMultiply.setOnClickListener(v -> addToExpression("*"));
        buttonDivide.setOnClickListener(v -> addToExpression("/"));

        // Código dos botões de limpar e calcular
        Button buttonClear = findViewById(R.id.button_clear);
        Button buttonEquals = findViewById(R.id.button_equals);

        buttonClear.setOnClickListener(v -> clearExpression());
        buttonEquals.setOnClickListener(v -> evaluateExpression());
    }

    private void addToExpression(String str) {
        expression.append(str);
        editText.setText(expression.toString());
    }

    private void clearExpression() {
        expression.setLength(0);
        editText.setText("");
    }

    private void evaluateExpression() {
        if (expression.length() == 0) return;

        String result;
        try {
            result = evaluate(expression.toString());
        } catch (Exception e) {
            result = "Error";
        }

        editText.setText(result);
        expression.setLength(0);
        expression.append(result);
    }

    private String evaluate(String expression) {
        return String.valueOf(new ExpressionEvaluator().evaluate(expression));
    }
}
