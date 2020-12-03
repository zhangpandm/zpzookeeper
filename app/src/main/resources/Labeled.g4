grammar Labeled;

prog:stat+;

stat: expr # sigleExpr
    | expr '=' expr #assign;

expr: expr op=('+'|'-') expr #addSub
    | expr op=('*'|'/') expr #mulDiv
    | expr '#' expr #TAND
    | NUM #NUM
    | ID  #ID
    | '('expr ')' #parens
    | '['expr','expr']' #multiFilter;

MUL:'*';

DIV:'/';

ADD:'+';

SUB:'-';

TAND:'#';

ID:[a-zA-Z]+[0-9]*'.'[a-zA-Z0-9]+[_]*[a-zA-Z0-9]*;
NUM: [0-9]+
    |'(''-'[0-9]+ ')'
    |[0-9]+'.'[0-9]+
    |'(''-'[0-9]+'.'[0-9]+ ')';

WS: [ \t\r\n] -> skip;