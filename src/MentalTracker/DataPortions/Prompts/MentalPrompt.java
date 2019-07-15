/*******************************************************************************************
 * @author: Nolan Rochon
 * @date: 07/07/19
 * @project: Mental Health Tracker
 *
 * This class holds a single prompt for the user. Once created these objects are stored
 *      in a list retrieved each time the questions are asked.
 *******************************************************************************************/
package MentalTracker.DataPortions.Prompts;

public class MentalPrompt {

    private String _Name;
    private String _Prompt;
    private int _Min;
    private int _Max;
    private PromptDataType _ResultType;

    public MentalPrompt (String name, String prompt, PromptDataType resultType)
    {
        _Name = name;
        _Prompt = prompt;
        _Min = 0;
    }

    public void SetMinMax (int min, int max)
    {
        _Min = min;
        _Max = max;
    }

    public void SetMax (int max)
    {
        _Max = max;
    }

    public String get_Name () {return _Name; }
    public String get_Prompt () {return _Prompt; }
    public int GetMin () { return _Min; }
    public int GetMax () { return _Max; }
    public PromptDataType GetDataType () { return _ResultType; }
}
