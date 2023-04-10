package java_homework_6;

public class laptop {
    private String manufacturer;
    private String model;
    private int diagonal;
    private String processor;
    private int ram;
    private int hd;
    private String os;

    public laptop(String manufacturer, String model, int diagonal, String processor, int ram, int hd, String os){
        this.manufacturer = manufacturer;
        this.model = model;
        this.diagonal = diagonal;
        this.processor = processor;
        this.ram = ram;
        this.hd = hd;
        this.os = os;
    }

    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public Integer getDiagonal() {
        return diagonal;
    }
    public void setDiagonal(Integer diagonal) {
        this.diagonal = diagonal;
    }
    public String getProcessor() {
        return processor;
    }
    public void setProcessor(String processor) {
        this.processor = processor;
    }
    public int getRam() {
        return ram;
    }
    public void setRam(int ram) {
        this.ram = ram;
    }
    public int getHd() {
        return hd;
    }
    public void setHd(int hd) {
        this.hd = hd;
    }
    public String getOs() {
        return os;
    }
    public void setOs(String os) {
        this.os = os;
    }
    @Override
    public String toString() {
        return "\nНоутбук " + manufacturer + " " + model + " " + diagonal + "\"/"
                + processor + "/RAM " + ram + " ГБ/" + "HDD " + hd + " ГБ/" + os;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        result = prime * result + ((processor == null) ? 0 : processor.hashCode());
        result = prime * result + ram;
        result = prime * result + hd;
        result = prime * result + ((os == null) ? 0 : os.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        laptop other = (laptop) obj;
        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;
        if (processor == null) {
            if (other.processor != null)
                return false;
        } else if (!processor.equals(other.processor))
            return false;
        if (ram != other.ram)
            return false;
        if (hd != other.hd)
            return false;
        if (os == null) {
            if (other.os != null)
                return false;
        } else if (!os.equals(other.os))
            return false;
        return true;
    }
   
    
    

   

    
}
