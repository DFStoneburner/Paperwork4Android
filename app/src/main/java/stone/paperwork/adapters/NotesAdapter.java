package stone.paperwork.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import stone.paperwork.R;
import stone.paperwork.models.Note;
import stone.paperwork.models.NotesResponse;

/**
 * Created by pirate_steve on 3/29/2015.
 */
public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {
    private NotesResponse content;

    public NotesAdapter(NotesResponse content) {
        this.content = content;
    }


    @Override
    public NotesAdapter.NotesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.row_notes_list, parent, false);

        return new NotesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NotesAdapter.NotesViewHolder holder, int position) {
        Note note = content.getResponse().get(position);
        holder.titleView.setText(note.getTitle());

        Spanned span = Html.fromHtml(note.getContent_preview());
        holder.summaryView.setText(span);
    }

    @Override
    public int getItemCount() {
        return content.size();
    }

    public class NotesViewHolder extends RecyclerView.ViewHolder {
        TextView titleView;
        TextView summaryView;

        public NotesViewHolder(View itemView) {
            super(itemView);

            titleView = (TextView) itemView.findViewById(R.id.text_title);
            summaryView = (TextView) itemView.findViewById(R.id.text_summary);
        }
    }
}
