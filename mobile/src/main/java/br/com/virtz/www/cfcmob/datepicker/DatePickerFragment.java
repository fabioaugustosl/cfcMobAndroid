package br.com.virtz.www.cfcmob.datepicker;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import br.com.virtz.www.cfcmob.activity.TarefaAulaActivity;

/**
 * Created by fabio on 11/04/16.
 */
public class DatePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener{

    Activity mListener = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener =  activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnTimeDialogListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        //Use the current time as the default values for the time picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        //Create and return a new instance of TimePickerDialog
        TimePickerDialog tpd = new TimePickerDialog(getActivity(),this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));

        /*.........Set a custom title for picker........*/
        TextView tvTitle = new TextView(getActivity());
        tvTitle.setText("Qual horário de início da aula?");
        tvTitle.setBackgroundColor(Color.parseColor("#6680cbc4"));
        tvTitle.setPadding(5, 5, 5, 5);
        tvTitle.setTextSize(18);
        tvTitle.setGravity(Gravity.CENTER_HORIZONTAL);
        tpd.setCustomTitle(tvTitle);

        return tpd;
    }

    //onTimeSet() callback method
    public void onTimeSet(TimePicker view, int hourOfDay, int minute){
        startActivity(new Intent(mListener.getBaseContext(), TarefaAulaActivity.class));
    }

}
