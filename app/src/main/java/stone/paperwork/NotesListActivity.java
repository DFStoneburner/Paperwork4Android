package stone.paperwork;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;

import stone.paperwork.adapters.NotebooksFetcher;
import stone.paperwork.models.NotesResponse;


public class NotesListActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NotebookSelectedCallbacks, NotesListFragment.OnNoteSelectedListener {

    private NavigationDrawerFragment mNavigationDrawerFragment;
    private Toolbar toolbar;
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);

        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            getMenuInflater().inflate(R.menu.notes_list, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNotebookSelected(String notebookID) {
        new FetchNotes(notebookID).execute();
    }

    @Override
    public void onNoteSelected(String noteID) {

    }

    private class FetchNotes extends AsyncTask<Void, Void, Boolean> {
        public NotesResponse response;
        public String notebook_id;

        public FetchNotes(String notebook_id) {
            this.notebook_id = notebook_id;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Void... arg0) {
            try {
                response = NotebooksFetcher.queryNotes(notebook_id);
                return true;
            } catch (IOException e) {
                Log.e("Notebooks Fetch", "IOExcept", e);
            }
            return false;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, NotesListFragment.newInstance(response))
                    .commit();
        }

    }
}
