package id.teamproject.praktikum.tb.chelseafcsqlite;

public class Player {
    private String _id, _name, _dob, _birthplace, _height, _weight, _position, _number;
    public Player(String id, String name, String dob, String birthplace, String height, String weight, String position, String number) {
        this._id = id;
        this._name = name;
        this._dob = dob;
        this._birthplace = birthplace;
        this._height = height;
        this._weight = weight;
        this._position = position;
        this._number = number;
    }
    public Player() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_name() {
        return _name;
    }
    public void set_name(String _name) {
        this._name = _name;
    }
    public String get_dob() {
        return _dob;
    }
    public void set_dob(String _dob) {
        this._dob = _dob;
    }
    public String get_birthplace() {
        return _birthplace;
    }
    public void set_birthplace(String _birthplace) {
        this._birthplace = _birthplace;
    }
    public String get_height() {
        return _height;
    }
    public void set_height(String _height) {
        this._height = _height;
    }
    public String get_weight() {
        return _weight;
    }
    public void set_weight(String _weight) {
        this._weight = _weight;
    }
    public String get_position() {
        return _position;
    }
    public void set_position(String _position) {
        this._position = _position;
    }
    public String get_number() {
        return _number;
    }
    public void set_number(String _number) {
        this._number = _number;
    }
}

