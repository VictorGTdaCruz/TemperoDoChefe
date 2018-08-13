package devmob.processoseletivo.temperodochefe.menu.view;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import devmob.processoseletivo.temperodochefe.R;
import devmob.processoseletivo.temperodochefe.menu.view.fragments.OrderDialogInterface;

public class NewOrderDialog extends Dialog {

    private EditText tableInput, peopleInput;
    private OrderDialogInterface orderDialogInterface;

    public NewOrderDialog(Fragment orderFragment, OrderDialogInterface orderDialogInterface) {
        super(orderFragment.getContext());
        this.orderDialogInterface = orderDialogInterface;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_menu_new_order);
        tableInput = findViewById(R.id.menu_dialog_edittext_table);
        peopleInput = findViewById(R.id.menu_dialog_edittext_people);
        Button positiveBtn = findViewById(R.id.menu_dialog_btn_positive);
        Button negativeBtn = findViewById(R.id.menu_dialog_btn_negative);

        positiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderDialogInterface.setVariables(tableInput.getText().toString(),
                        peopleInput.getText().toString());
                dismiss();
            }
        });

        negativeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

    }
}
