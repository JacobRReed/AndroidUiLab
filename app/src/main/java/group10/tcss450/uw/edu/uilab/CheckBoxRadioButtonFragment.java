package group10.tcss450.uw.edu.uilab;


import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class CheckBoxRadioButtonFragment extends Fragment {


    public CheckBoxRadioButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_check_box_radio_button, container, false);
        RadioButton rb = v.findViewById(R.id.radioYes);
        rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRadioButtonClicked(view);
            }
        });

        rb = v.findViewById(R.id.radioNo);
        rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRadioButtonClicked(view);
            }
        });

        Button b = v.findViewById(R.id.submitButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitToast();
            }
        });

        return v;

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        GradientDrawable bg = (GradientDrawable)
                getActivity().findViewById(R.id.radioGroup).getBackground();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioYes:
                if (checked)
                    bg.setColor(getResources().getColor(R.color.yes));
                break;
            case R.id.radioNo:
                if (checked)
                    bg.setColor(getResources().getColor(R.color.no));
                break;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        GradientDrawable bg = (GradientDrawable)
                getActivity().findViewById(R.id.radioGroup).getBackground();
        bg.setColor(getResources().getColor(R.color.fill));
    }

    public void submitToast() {
        String toastNotification = "You selected the following topping(s):";
        CheckBox cheese = getView().findViewById(R.id.checkBoxCheese);
        CheckBox meat = getView().findViewById(R.id.checkBoxMeat);
        CheckBox sauce = getView().findViewById(R.id.checkBoxSauce);
        CheckBox veg = getView().findViewById(R.id.checkBoxVeggies);
        boolean cheeseBool = cheese.isChecked();
        boolean meatBool = meat.isChecked();
        boolean sauceBool = sauce.isChecked();
        boolean vegBool = veg.isChecked();

        if(cheeseBool) {
            toastNotification += "cheese,";
        }
        if(meatBool) {
            toastNotification += "meat,";
        }
        if(sauceBool) {
            toastNotification += "sauce,";
        }
        if(vegBool) {
            toastNotification += "vegetables,";
        }

        toastNotification = toastNotification.replaceAll(",$", "");

        Toast.makeText(getActivity(),
                toastNotification.toString(),
                Toast.LENGTH_LONG).show();
    }
}
