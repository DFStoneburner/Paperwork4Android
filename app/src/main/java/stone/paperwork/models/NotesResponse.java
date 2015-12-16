package stone.paperwork.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pirate_steve on 4/6/2015.
 */
public class NotesResponse extends Response implements Parcelable {
    public List<Note> response;

    public NotesResponse(Parcel source) {
        response = new ArrayList<Note>();
        int size = source.readInt();
        if (size > 0) {
            source.readTypedList(response, Note.CREATOR);
        }
    }

    public List<Note> getResponse() {
        return response;
    }

    public void setResponse(List<Note> response) {
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

    public static final Parcelable.Creator<NotesResponse> CREATOR =
            new Parcelable.Creator<NotesResponse>() {

                @Override
                public NotesResponse createFromParcel(Parcel source) {
                    return new NotesResponse(source);
                }

                @Override
                public NotesResponse[] newArray(int size) {
                    return new NotesResponse[size];
                }
            };
}
