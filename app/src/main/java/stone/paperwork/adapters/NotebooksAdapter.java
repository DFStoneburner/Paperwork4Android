package stone.paperwork.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import stone.paperwork.R;
import stone.paperwork.models.Notebook;
import stone.paperwork.models.NotebooksResponse;

/**
 * Created by pirate_steve on 3/29/2015.
 */
public class NotebooksAdapter extends RecyclerView.Adapter<NotebooksAdapter.NotebookViewHolder> {
    private NotebooksResponse content;
    private iNotebookSelected listener;

    public NotebooksAdapter(NotebooksResponse content, iNotebookSelected listener) {
        this.content = content;
        this.listener = listener;
    }


    @Override
    public NotebooksAdapter.NotebookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.row_notebooks_nav, parent, false);

        NotebookViewHolder holder = new NotebookViewHolder(itemView);
        holder.titleView = (TextView) itemView.findViewById(R.id.notebook_title);
        itemView.setOnClickListener(holder);

        return holder;
    }

    @Override
    public void onBindViewHolder(NotebooksAdapter.NotebookViewHolder holder, int position) {
        Notebook notebook = content.getResponse().get(position);
        holder.titleView.setText(notebook.getTitle());
        holder.notebookID = notebook.getId();
    }

    @Override
    public int getItemCount() {
        return content.size();
    }

    public class NotebookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titleView;
        String notebookID;

        public NotebookViewHolder(View itemView) {
            super(itemView);

            titleView = (TextView) itemView.findViewById(R.id.notebook_title);
        }

        @Override
        public void onClick(View v) {
            if (notebookID != null) {
                NotebooksAdapter.this.listener.onNotebookSelected(notebookID);
            }
        }
    }

    public interface iNotebookSelected {
        void onNotebookSelected(String notebookID);
    }
}
