grammar Car;

@parser::members {

private Car car;

public CarParser(TokenStream input, Car car) {
    this(input);
    this.car = car;
}
}

program: sentence* ;
sentence: command ;
command: run_forward | run_backwards | turn_left | turn_right | set_color ;
run_forward: RF numeric_value 
	{
		car.forward((float)$numeric_value.value);
	};
run_backwards: RB numeric_value 
	{
		car.backwards((float)$numeric_value.value);
	};
turn_left: TL numeric_value 
	{
		car.left((float)$numeric_value.value);
	};
turn_right: TR numeric_value 
	{
		car.right((float)$numeric_value.value);
	};
set_color: SC n1=numeric_value COMMA n2=numeric_value COMMA n3=numeric_value COMMA n4=numeric_value 
	{
		car.color((float)$n1.value,(float)$n2.value,(float)$n3.value,(float)$n4.value);
	};
numeric_value returns [Object value]: 
	NUMBER { $value = Float.parseFloat($NUMBER.text); };

//Palabras clave
VAR: 'var';
FUNCTION: 'procedure';
IF: 'if';
ELSE: 'else';
WHILE: 'while';
RF: 'run_forward';
RB: 'run_backwards';
TL: 'turn_left';
TR: 'turn_right';
SC: 'set_color';
WRITELN: 'writeln';

//Operadores Aritmeticos
PLUS: '+';
MINUS: '-';
MULT: '*';
DIV: '/';
GT: '>';
LT: '<';
GEQ: '>=';
LEQ: '<=';
EQ: '==';
NEQ: '<>';

ASSIGN: '=';

//Operadores logicos
AND: '&&';
OR: '||';
NOT: '!';

//otros
BRACKET_OPEN: '{';
BRACKET_CLOSE: '}';
PAR_OPEN: '(';
PAR_CLOSE: ')';
COMMA: ',';

//Constantes
TRUE: 'true';
FALSE: 'false';

STRING: '"'[.^"]*'"';
ID: [a-zA-Z_][a-zA-Z0-9_]*;
NUMBER: ('-')?[0-9]+(['.'][0-9]+)?;

WS
:
	[ \t\r\n]+ -> skip
;