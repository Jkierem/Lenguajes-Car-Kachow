grammar Car;

@parser::header{
	import java.util.List;
	import java.util.ArrayList;
	import co.edu.javeriana.car.interpreter.*;
	import co.edu.javeriana.car.interpreter.commands.*;
	import co.edu.javeriana.car.interpreter.control.*;
	import co.edu.javeriana.car.interpreter.operations.comparison.*;
	import co.edu.javeriana.car.interpreter.operations.logical.*;
	import co.edu.javeriana.car.interpreter.operations.numeric.*;
	import co.edu.javeriana.car.interpreter.values.*;
}

@parser::members {

private Car car;

public CarParser(TokenStream input, Car car) {
    this(input);
    this.car = car;
}
}

program returns [ASTNode node]:	
	{
		List<ASTNode> body = new ArrayList<>();	
	} (s=sentence{
		body.add( $s.node );
	})*
	{
		$node = new Program(body);
	};

sentence returns [ASTNode node]: 
	s=conditional { $node = $s.node; } | 
	s1=while_loop  { $node = $s1.node; } | 
	s2=command     { $node = $s2.node; } |
	s3=var_declare|
	s4=var_assign;
	
command returns [ASTNode node]: 
	c=run_forward   { $node = $c.node; } | 
	c1=run_backwards { $node = $c1.node; } | 
	c2=turn_left     { $node = $c2.node; } | 
	c3=turn_right    { $node = $c3.node; } | 
	c4=set_color     { $node = $c4.node; } |
	c5=writeln       { $node = $c5.node; } ;

run_forward returns [ASTNode node]: RF numeric_expression 
	{
		$node = new RunForwards(car,$numeric_expression.node);
	};
run_backwards returns [ASTNode node]: RB numeric_expression 
	{
		$node = new RunBackwards(car,$numeric_expression.node);
	};
turn_left returns [ASTNode node]: TL numeric_expression 
	{
		$node = new TurnLeft(car,$numeric_expression.node);	
	};
turn_right returns [ASTNode node]: TR numeric_expression 
	{
		$node = new TurnRight(car,$numeric_expression.node);
	};
set_color returns [ASTNode node]: SC n1=numeric_expression COMMA n2=numeric_expression COMMA n3=numeric_expression COMMA n4=numeric_expression 
	{
		$node = new SetColor(car,$n1.node,$n2.node,$n3.node,$n4.node);
	};
	
writeln returns [ASTNode node]: 
	WRITELN s=string_value{	$node = new Writeln($s.node);}|
	WRITELN s1=numeric_expression{ $node = new Writeln($s1.node);}|
	WRITELN s2=logical_expression{ $node = new Writeln($s2.node);}
	;
	
while_loop returns [ASTNode node]: 
	WHILE PAR_OPEN l=logical_expression PAR_CLOSE BRACKET_OPEN
		{
			List<ASTNode> body = new ArrayList<>();	
		}
		(s1=sentence { body.add($s1.node); })*
	BRACKET_CLOSE { $node = new While( $l.node , body );}
;
	
conditional returns [ASTNode node]: IF PAR_OPEN l=logical_expression PAR_CLOSE BRACKET_OPEN 
				{
					List<ASTNode> main_body = new ArrayList<>();
					List<ASTNode> else_body = new ArrayList<>();
				}
				(s1=sentence { main_body.add($s1.node); })*  
			BRACKET_CLOSE ( ELSE BRACKET_OPEN 
				(s2=sentence { else_body.add($s2.node); })*
			BRACKET_CLOSE )?{
				$node = new Conditional($l.node , main_body , else_body);
			};

var_declare returns [ASTNode node]:
	VAR ID;

var_assign returns [ASTNode node]:
	ID ASSIGN string_value
	ID ASSIGN numeric_expression
	ID ASSIGN logical_expression;

logical_expression returns [ASTNode node]: 
	PAR_OPEN l=logical_expression PAR_CLOSE { $node = $l.node; } | 
	l1=logical_expression AND l2=logical_expression { $node = new And($l1.node,$l2.node); } |
	l1=logical_expression OR  l2=logical_expression { $node = new Or($l1.node,$l2.node); }| 
	NOT l=logical_expression { $node = new Not($l.node); }|
	l1=logical_expression EQ  l2=logical_expression { $node = new Equality($l1.node,$l2.node); }|
	l1=logical_expression NEQ l2=logical_expression { $node = new Inequality($l1.node,$l2.node); }|
	n1=numeric_expression GT  n2=numeric_expression { $node = new GreaterThan($n1.node,$n2.node); }|
	n1=numeric_expression LT  n2=numeric_expression { $node = new LessThan($n1.node,$n2.node); }|
	n1=numeric_expression GEQ n2=numeric_expression { $node = new GreaterOrEqualThan($n1.node,$n2.node); }|
	n1=numeric_expression LEQ n2=numeric_expression { $node = new LessOrEqualThan($n1.node,$n2.node); }|
	n1=numeric_expression EQ  n2=numeric_expression { $node = new Equality($n1.node,$n2.node); }|
	n1=numeric_expression NEQ n2=numeric_expression { $node = new Inequality($n1.node,$n2.node); }|
	s1=string_value EQ  s2=string_value { $node = new Equality($s1.node,$s2.node); }|
	s1=string_value NEQ s2=string_value { $node = new Equality($s1.node,$s2.node); }|
	logical_value { $node = $logical_value.node; }
;

numeric_expression returns [ASTNode node]: 
	PAR_OPEN e1=numeric_expression PAR_CLOSE { $node = $e1.node; }|
	e2=numeric_expression MULT  e3=numeric_expression { $node = new Multiplication($e2.node , $e3.node); } |
	e4=numeric_expression DIV   e5=numeric_expression { $node = new Division($e4.node , $e5.node); } |
	e6=numeric_expression PLUS  e7=numeric_expression { $node = new Addition($e6.node , $e7.node); } |
	e8=numeric_expression MINUS e9=numeric_expression { $node = new Substraction($e8.node , $e9.node); } |
	numeric_value { $node = $numeric_value.node; }
;

string_value returns [ASTNode node]: 
	STRING{ $node = new StringValue($STRING.text); };

logical_value returns [ASTNode node]: 
	TRUE { $node = new LogicalValue($TRUE.text); } | 
	FALSE { $node = new LogicalValue($FALSE.text); };

numeric_value returns [ASTNode node]: 
	NUMBER { $node = new NumericValue($NUMBER.text); };

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

STRING: '"' ~'"'* '"';
ID: [a-zA-Z_][a-zA-Z0-9_]*;
NUMBER: ('-')?[0-9]+(['.'][0-9]+)?;

WS
:
	[ \t\r\n]+ -> skip
;