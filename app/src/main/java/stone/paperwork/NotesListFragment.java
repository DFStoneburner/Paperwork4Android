package stone.paperwork;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import stone.paperwork.adapters.NotesAdapter;
import stone.paperwork.models.NotesResponse;

public class NotesListFragment extends Fragment {
    private static final String ARG_NOTEBOOK = "notebook";

    private NotesResponse notes;

    private OnNoteSelectedListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param notes Parameter 1.
     * @return A new instance of fragment NotesListFragment.
     */
    public static NotesListFragment newInstance(NotesResponse notes) {
        NotesListFragment fragment = new NotesListFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_NOTEBOOK, notes);
        fragment.setArguments(args);
        return fragment;
    }

    public NotesListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment_notes_list, container, false);

        RecyclerView recList = (RecyclerView) view.findViewById(R.id.notes_list);
        LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        if (getArguments() != null) {
            notes = getArguments().getParcelable(ARG_NOTEBOOK);
            recList.setAdapter(new NotesAdapter(notes));
        }

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnNoteSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnNoteSelectedListener {
        public void onNoteSelected(String noteID);
    }

}
