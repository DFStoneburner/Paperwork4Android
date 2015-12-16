package stone.paperwork.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by pirate_steve on 4/6/2015.
 */
public class Tag implements Parcelable {
    private String id;
    private String title;
    private String visibility;

    public Tag(Parcel source) {
        id = source.readString();
        title = source.readString();
        visibility = source.readString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        dest.writeString(visibility);
    }

    public static final Parcelable.Creator<Tag> CREATOR =
            new Parcelable.Creator<Tag>() {

                @Override
                public Tag createFromParcel(Parcel source) {
                    return new Tag(source);
                }

                @Override
                public Tag[] newArray(int size) {
                    return new Tag[size];
                }
            };
}
