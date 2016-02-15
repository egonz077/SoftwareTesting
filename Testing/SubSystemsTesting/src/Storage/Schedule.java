package Storage;

import java.util.Collection;

public class Schedule {
	
	
	private  String id;
    private  String pantherID;
    private Collection<ClassDetails> classes;

    public Schedule(String pantherID)
    {
        this.pantherID = pantherID;
    }

    public Schedule(Collection classes) {
        this.classes = classes;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getPantherID()
    {
        return pantherID;
    }

    public void setPantherID(String pantherID)
    {
        this.pantherID = pantherID;
    }

	public Collection<ClassDetails> getClasses()
	{
        return classes;
    }
	
	public void combine (String id)
	{}
	
	public void addClass (String id)
	{}
	
	public void deleteClass (String id)
	{}

    public void addClass(Collection<ClassDetails> classes) {
    }

}
