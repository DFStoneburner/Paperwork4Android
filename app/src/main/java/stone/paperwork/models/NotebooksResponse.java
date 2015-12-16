package stone.paperwork.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pirate_steve on 3/29/2015.
 */
public class NotebooksResponse extends Response implements Parcelable {
    public List<Notebook> response;

    public NotebooksResponse(Parcel source) {
        response = new ArrayList<Notebook>();
        int size = source.readInt();
        if (size > 0) {
            source.readTypedList(response, Notebook.CREATOR);
        }
    }

    public List<Notebook> getResponse() {
        return response;
    }

    public void setResponse(List<Notebook> response) {
        this.response = response;
    }

    public int size() {
        return response.size();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (response.size() > 0) {
            dest.writeInt(response.size());
            dest.writeTypedList(response);
        } else {
            dest.writeInt(0);
        }
    }

    public static final Parcelable.Creator<NotebooksResponse> CREATOR =
            new Parcelable.Creator<NotebooksResponse>() {

                @Override
                public NotebooksResponse createFromParcel(Parcel source) {
                    return new NotebooksResponse(source);
                }

                @Override
                public NotebooksResponse[] newArray(int size) {
                    return new NotebooksResponse[size];
                }
            };
}
