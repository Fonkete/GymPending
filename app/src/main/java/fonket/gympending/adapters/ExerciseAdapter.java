package fonket.gympending.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import fonket.gympending.R;
import fonket.gympending.data.Queries;
import fonket.gympending.models.Exercise;

/**
 * Created by felip on 28-05-2017.
 */

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ViewHolder> {

    private List<Exercise> exercises = new Queries().exercises();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_exercise, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Exercise exercise = exercises.get(position);
        CheckBox checkBox = holder.checkBox;
        checkBox.setChecked(exercise.isWatched());
        TextView textView = holder.textView;
        textView.setText(exercise.getName());
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CheckBox checkBox;
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            checkBox = (CheckBox) itemView.findViewById(R.id.exerciseCb);
            textView = (TextView) itemView.findViewById(R.id.exerciseTv);
        }
    }
}
