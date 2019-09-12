package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public static final String LOCATION_SEPARATOR = "of";
    public static final String DEFAULT_OFFSET = "Near of";

    public EarthquakeAdapter(Activity Context, ArrayList<Earthquake> arrayList) {
        super(Context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Earthquake currentInfo = getItem(position);

        TextView magnitudeView = listItemView.findViewById(R.id.magnitude);
        TextView primarylocationView = listItemView.findViewById(R.id.primary_location);
        TextView offsetView = listItemView.findViewById(R.id.location_offset);
        TextView dateView = listItemView.findViewById(R.id.date);
        TextView timeView = listItemView.findViewById(R.id.time);

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
        int magnitudeColour = getMagnitudeColour(currentInfo.getMagnitude());
        magnitudeCircle.setColor(magnitudeColour);

        String magnitude = MagnitudeFormat(currentInfo.getMagnitude());
        magnitudeView.setText(magnitude);
        String primarylocation, offset;
        String place = currentInfo.getPlace();

        if (place.contains(LOCATION_SEPARATOR)) {
            String[] split = place.split(LOCATION_SEPARATOR, 2);
            offset = split[0] + LOCATION_SEPARATOR;
            primarylocation = split[1];

        } else {
            offset = DEFAULT_OFFSET;
            primarylocation = currentInfo.getPlace();
        }

        primarylocationView.setText(primarylocation);
        offsetView.setText(offset);

        long timeinmillisecond = currentInfo.getDate();
        Date date = new Date(timeinmillisecond);
        String dateToDisplay = DateFormat(date);
        dateView.setText(dateToDisplay);
        String timeToDisplay = TimeFormat(date);
        timeView.setText(timeToDisplay);
        return listItemView;
    }

    String DateFormat(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return simpleDateFormat.format(date);
    }

    String TimeFormat(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:m a");
        return simpleDateFormat.format(date);
    }

    String MagnitudeFormat(Double magnitude) {
        DecimalFormat formatter = new DecimalFormat("0.0");
        return formatter.format(magnitude);
    }

    int getMagnitudeColour(double magnitude) {

        int mag = (int) magnitude;
        int magnitudeColour;
        switch (mag) {
            case 0:

            case 1:
                magnitudeColour = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;

            case 2:
                magnitudeColour = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;

            case 3:
                magnitudeColour = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;

            case 4:
                magnitudeColour = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;

            case 5:
                magnitudeColour = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;

            case 6:
                magnitudeColour = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;

            case 7:
                magnitudeColour = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;

            case 8:
                magnitudeColour = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;

            case 9:
                magnitudeColour = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;

            default:
                magnitudeColour = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                break;
        }
        return magnitudeColour;
    }


}
