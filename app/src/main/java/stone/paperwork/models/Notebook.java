package stone.paperwork.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by pirate_steve on 3/29/2015.
 */
public class Notebook implements Parcelable {
    public String id;
    public String type;
    public String title;
    public Notebook[] children;

    public Notebook(Parcel source) {
        children = new Notebook[source.readInt()];
        id = source.readString();
        type = source.readString();
        title = source.readString();
        for (int i = 0; i < children.length; i++) {
            children[i] = new Notebook(source);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Notebook[] getChildren() {
        return children;
    }

    public void setChildren(Notebook[] children) {
        this.children = children;
    }

    public int size() {
        return children.length;
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
        if (children == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(children.length);
        }
        dest.writeString(id);
        dest.writeString(type);
        dest.writeString(title);
    }

    public static final Parcelable.Creator<Notebook> CREATOR =
            new Parcelable.Creator<Notebook>() {

                @Override
                public Notebook createFromParcel(Parcel source) {
                    return new Notebook(source);
                }

                @Override
                public Notebook[] newArray(int size) {
                    return new Notebook[size];
                }
            };
}
