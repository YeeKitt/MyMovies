package sg.edu.rp.c346.mymovies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 16030820 on 23/7/2018.
 */

public class CustomAdapter extends ArrayAdapter{
    Context parent_context;
    int layout_id;
    ArrayList<Movie> movieList;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Movie> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Obtain the LayoutInflater object.
        LayoutInflater inflater = (LayoutInflater) parent_context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // Inflate a new view hierarchy from the specified xml resource (layout_id)
        // and return the root View of the inflated hierarchy.
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI elements and bind them to their respective Java variable.
        ImageView ivImg = rowView.findViewById(R.id.imageViewRated);
        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvYrGenre = rowView.findViewById(R.id.textViewYrGenre);

        // Obtain the property values from the Data Class object
        // and set them to the corresponding UI elements.
        Movie currentItem = movieList.get(position);

        if (currentItem.getRated().equals("g")) {
            ivImg.setImageResource(R.drawable.rating_g);
        }

        else if (currentItem.getRated().equals("pg")){
            ivImg.setImageResource(R.drawable.rating_pg);
        }

        else if (currentItem.getRated().equals("pg13")){
            ivImg.setImageResource(R.drawable.rating_pg13);
        }

        else if (currentItem.getRated().equals("nc16")){
            ivImg.setImageResource(R.drawable.rating_nc16);
        }

        else if (currentItem.getRated().equals("m18")){
            ivImg.setImageResource(R.drawable.rating_m18);
        }

        else if (currentItem.getRated().equals("r21")){
            ivImg.setImageResource(R.drawable.rating_r21);
        }

        tvTitle.setText(currentItem.getTitle());
        tvYrGenre.setText(currentItem.getYear() + " - " + currentItem.getGenre());

        // Return the View corresponding to the data at the specified position.
        return rowView;
    }
}
