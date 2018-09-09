package net.leocadio.joao.androidcompras2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends Activity {

    private CheckBox chkItem1, chkItem2, chkItem3, chkItem4, chkItem5;
    private RadioButton rdBoleto, rdCartao, rdCartaoParc;
    private Button btnTotal;
    private TextView txtTotal;

    double total, save, disconto; // 25%;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButtonClick();
    }

    public void addListenerOnButtonClick()
    {
        chkItem1 = findViewById(R.id.chbItem1);
        chkItem2 = findViewById(R.id.chbItem2);
        chkItem3 = findViewById(R.id.chbItem3);
        chkItem4 = findViewById(R.id.chbItem4);
        chkItem5 = findViewById(R.id.chbItem5);

        rdBoleto = findViewById(R.id.rdbtnBoleto);
        rdCartao = findViewById(R.id.rdbtnCartaoVista);
        rdCartaoParc = findViewById(R.id.rdbtnCartaoParcelado);

        txtTotal = findViewById(R.id.txtvTotal);

        btnTotal = findViewById(R.id.btnOK);

        btnTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                total = 0.0;

                if (chkItem1.isChecked()) {
                    total += 29.90;
                }
                if (chkItem2.isChecked()) {
                    total += 79.90;
                }
                if (chkItem3.isChecked()) {
                    total += 390.79;
                }
                if (chkItem4.isChecked()) {
                    total += 69.90;
                }
                if (chkItem5.isChecked()) {
                    total += 177.65;
                }

                if (rdBoleto.isChecked()) {
                    save = 100 - 5;
                    disconto = (total * save) / 100;
                    txtTotal.setText(String.format("%.2f", disconto));
                }

                if (rdCartao.isChecked()) {
                    txtTotal.setText(String.format("%.2f", total));
                }

                if (rdCartaoParc.isChecked()) {
                    txtTotal.setText("Total: " + Math.round(total) + "12 X R$ " + Math.round(total / 12));
                }
            }
        });
    }
}
