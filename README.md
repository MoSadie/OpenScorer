# OpenScorer
OpenSource Text File based scoring system

###Example Text File:
```
JLabel,Label To Appear On Screen;
JTextField,Label2,15;
JPasswordField,L A B E L,15;
JTextArea,LabelOfArea,5,15,true;
JCheckBox,CheckCheck;
```
####Result:
![alt tag](Images/ExampleTxtResults.png)

####Here is a breakdown:

######JLabel:
```
JLabel,{OnScreenLabel};
```

######JTextField:
```
JTextField,{OutputLabel},{Length};
```

######JPasswordField:
```
JPasswordField,{OutputLabel},{Length};
```

######JTextArea:
```
JTextArea,{OutputLabel},{VerticalLength},{HorizontialLength},{WrapTextAround};
```

######JCheckBox:
```
JCheckBox,{OutputLabel};
```
