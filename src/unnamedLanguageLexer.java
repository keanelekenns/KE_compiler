// $ANTLR 3.5.2 src\\unnamedLanguage.g 2020-03-29 18:58:52



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class unnamedLanguageLexer extends Lexer {
	public static final int EOF=-1;
	public static final int ADDOP=4;
	public static final int ASSIGNOP=5;
	public static final int BOOLLIT=6;
	public static final int BOOLTYPE=7;
	public static final int CHARLIT=8;
	public static final int CHARTYPE=9;
	public static final int CLOSEBRACE=10;
	public static final int CLOSEBRACKET=11;
	public static final int CLOSEPAREN=12;
	public static final int COMMA=13;
	public static final int COMMENT=14;
	public static final int ELSE=15;
	public static final int EQUALITYOP=16;
	public static final int FLOATLIT=17;
	public static final int FLOATTYPE=18;
	public static final int ID=19;
	public static final int IF=20;
	public static final int INTLIT=21;
	public static final int INTTYPE=22;
	public static final int LESSTHANOP=23;
	public static final int MULTOP=24;
	public static final int OPENBRACE=25;
	public static final int OPENBRACKET=26;
	public static final int OPENPAREN=27;
	public static final int PRINT=28;
	public static final int PRINTLN=29;
	public static final int RETURN=30;
	public static final int SEMICOLON=31;
	public static final int STRLIT=32;
	public static final int STRTYPE=33;
	public static final int SUBOP=34;
	public static final int VOIDTYPE=35;
	public static final int WHILE=36;
	public static final int WS=37;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public unnamedLanguageLexer() {} 
	public unnamedLanguageLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public unnamedLanguageLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "src\\unnamedLanguage.g"; }

	// $ANTLR start "OPENPAREN"
	public final void mOPENPAREN() throws RecognitionException {
		try {
			int _type = OPENPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:241:10: ( '(' )
			// src\\unnamedLanguage.g:241:12: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPENPAREN"

	// $ANTLR start "CLOSEPAREN"
	public final void mCLOSEPAREN() throws RecognitionException {
		try {
			int _type = CLOSEPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:244:11: ( ')' )
			// src\\unnamedLanguage.g:244:13: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLOSEPAREN"

	// $ANTLR start "OPENBRACE"
	public final void mOPENBRACE() throws RecognitionException {
		try {
			int _type = OPENBRACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:247:10: ( '{' )
			// src\\unnamedLanguage.g:247:12: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPENBRACE"

	// $ANTLR start "CLOSEBRACE"
	public final void mCLOSEBRACE() throws RecognitionException {
		try {
			int _type = CLOSEBRACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:250:11: ( '}' )
			// src\\unnamedLanguage.g:250:13: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLOSEBRACE"

	// $ANTLR start "OPENBRACKET"
	public final void mOPENBRACKET() throws RecognitionException {
		try {
			int _type = OPENBRACKET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:253:12: ( '[' )
			// src\\unnamedLanguage.g:253:14: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPENBRACKET"

	// $ANTLR start "CLOSEBRACKET"
	public final void mCLOSEBRACKET() throws RecognitionException {
		try {
			int _type = CLOSEBRACKET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:256:13: ( ']' )
			// src\\unnamedLanguage.g:256:15: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLOSEBRACKET"

	// $ANTLR start "SEMICOLON"
	public final void mSEMICOLON() throws RecognitionException {
		try {
			int _type = SEMICOLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:259:10: ( ';' )
			// src\\unnamedLanguage.g:259:12: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMICOLON"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:262:6: ( ',' )
			// src\\unnamedLanguage.g:262:8: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "ASSIGNOP"
	public final void mASSIGNOP() throws RecognitionException {
		try {
			int _type = ASSIGNOP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:265:9: ( '=' )
			// src\\unnamedLanguage.g:265:11: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASSIGNOP"

	// $ANTLR start "EQUALITYOP"
	public final void mEQUALITYOP() throws RecognitionException {
		try {
			int _type = EQUALITYOP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:268:11: ( '==' )
			// src\\unnamedLanguage.g:268:13: '=='
			{
			match("=="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQUALITYOP"

	// $ANTLR start "LESSTHANOP"
	public final void mLESSTHANOP() throws RecognitionException {
		try {
			int _type = LESSTHANOP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:271:11: ( '<' )
			// src\\unnamedLanguage.g:271:13: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LESSTHANOP"

	// $ANTLR start "ADDOP"
	public final void mADDOP() throws RecognitionException {
		try {
			int _type = ADDOP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:274:6: ( '+' )
			// src\\unnamedLanguage.g:274:8: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ADDOP"

	// $ANTLR start "SUBOP"
	public final void mSUBOP() throws RecognitionException {
		try {
			int _type = SUBOP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:277:6: ( '-' )
			// src\\unnamedLanguage.g:277:8: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SUBOP"

	// $ANTLR start "MULTOP"
	public final void mMULTOP() throws RecognitionException {
		try {
			int _type = MULTOP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:280:7: ( '*' )
			// src\\unnamedLanguage.g:280:9: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MULTOP"

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:283:3: ( 'if' )
			// src\\unnamedLanguage.g:283:5: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IF"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:286:5: ( 'else' )
			// src\\unnamedLanguage.g:286:7: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELSE"

	// $ANTLR start "WHILE"
	public final void mWHILE() throws RecognitionException {
		try {
			int _type = WHILE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:289:6: ( 'while' )
			// src\\unnamedLanguage.g:289:8: 'while'
			{
			match("while"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHILE"

	// $ANTLR start "PRINT"
	public final void mPRINT() throws RecognitionException {
		try {
			int _type = PRINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:292:6: ( 'print' )
			// src\\unnamedLanguage.g:292:8: 'print'
			{
			match("print"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRINT"

	// $ANTLR start "PRINTLN"
	public final void mPRINTLN() throws RecognitionException {
		try {
			int _type = PRINTLN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:295:8: ( 'println' )
			// src\\unnamedLanguage.g:295:10: 'println'
			{
			match("println"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRINTLN"

	// $ANTLR start "RETURN"
	public final void mRETURN() throws RecognitionException {
		try {
			int _type = RETURN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:298:7: ( 'return' )
			// src\\unnamedLanguage.g:298:9: 'return'
			{
			match("return"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RETURN"

	// $ANTLR start "STRTYPE"
	public final void mSTRTYPE() throws RecognitionException {
		try {
			int _type = STRTYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:301:8: ( 'string' )
			// src\\unnamedLanguage.g:301:10: 'string'
			{
			match("string"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRTYPE"

	// $ANTLR start "FLOATTYPE"
	public final void mFLOATTYPE() throws RecognitionException {
		try {
			int _type = FLOATTYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:304:10: ( 'float' )
			// src\\unnamedLanguage.g:304:12: 'float'
			{
			match("float"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOATTYPE"

	// $ANTLR start "CHARTYPE"
	public final void mCHARTYPE() throws RecognitionException {
		try {
			int _type = CHARTYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:307:9: ( 'char' )
			// src\\unnamedLanguage.g:307:11: 'char'
			{
			match("char"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHARTYPE"

	// $ANTLR start "INTTYPE"
	public final void mINTTYPE() throws RecognitionException {
		try {
			int _type = INTTYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:310:8: ( 'int' )
			// src\\unnamedLanguage.g:310:10: 'int'
			{
			match("int"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTTYPE"

	// $ANTLR start "BOOLTYPE"
	public final void mBOOLTYPE() throws RecognitionException {
		try {
			int _type = BOOLTYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:313:9: ( 'boolean' )
			// src\\unnamedLanguage.g:313:11: 'boolean'
			{
			match("boolean"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BOOLTYPE"

	// $ANTLR start "VOIDTYPE"
	public final void mVOIDTYPE() throws RecognitionException {
		try {
			int _type = VOIDTYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:316:9: ( 'void' )
			// src\\unnamedLanguage.g:316:11: 'void'
			{
			match("void"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VOIDTYPE"

	// $ANTLR start "BOOLLIT"
	public final void mBOOLLIT() throws RecognitionException {
		try {
			int _type = BOOLLIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:319:8: ( 'true' | 'false' )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0=='t') ) {
				alt1=1;
			}
			else if ( (LA1_0=='f') ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// src\\unnamedLanguage.g:319:10: 'true'
					{
					match("true"); 

					}
					break;
				case 2 :
					// src\\unnamedLanguage.g:319:17: 'false'
					{
					match("false"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BOOLLIT"

	// $ANTLR start "STRLIT"
	public final void mSTRLIT() throws RecognitionException {
		try {
			int _type = STRLIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:322:7: ( '\"' ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' | '!' | '\\.' | COMMA | ':' | ' ' | OPENBRACE | CLOSEBRACE | ( '0' .. '9' ) )* '\"' )
			// src\\unnamedLanguage.g:322:9: '\"' ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' | '!' | '\\.' | COMMA | ':' | ' ' | OPENBRACE | CLOSEBRACE | ( '0' .. '9' ) )* '\"'
			{
			match('\"'); 
			// src\\unnamedLanguage.g:322:13: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' | '!' | '\\.' | COMMA | ':' | ' ' | OPENBRACE | CLOSEBRACE | ( '0' .. '9' ) )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= ' ' && LA2_0 <= '!')||LA2_0==','||LA2_0=='.'||(LA2_0 >= '0' && LA2_0 <= ':')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= '{')||LA2_0=='}') ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// src\\unnamedLanguage.g:
					{
					if ( (input.LA(1) >= ' ' && input.LA(1) <= '!')||input.LA(1)==','||input.LA(1)=='.'||(input.LA(1) >= '0' && input.LA(1) <= ':')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= '{')||input.LA(1)=='}' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop2;
				}
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRLIT"

	// $ANTLR start "CHARLIT"
	public final void mCHARLIT() throws RecognitionException {
		try {
			int _type = CHARLIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:325:8: ( '\\'' ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' | '!' | '\\.' | COMMA | ':' | ' ' | OPENBRACE | CLOSEBRACE | ( '0' .. '9' ) ) '\\'' )
			// src\\unnamedLanguage.g:325:10: '\\'' ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' | '!' | '\\.' | COMMA | ':' | ' ' | OPENBRACE | CLOSEBRACE | ( '0' .. '9' ) ) '\\''
			{
			match('\''); 
			if ( (input.LA(1) >= ' ' && input.LA(1) <= '!')||input.LA(1)==','||input.LA(1)=='.'||(input.LA(1) >= '0' && input.LA(1) <= ':')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= '{')||input.LA(1)=='}' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			match('\''); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHARLIT"

	// $ANTLR start "INTLIT"
	public final void mINTLIT() throws RecognitionException {
		try {
			int _type = INTLIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:328:7: ( ( '0' .. '9' )+ )
			// src\\unnamedLanguage.g:328:9: ( '0' .. '9' )+
			{
			// src\\unnamedLanguage.g:328:9: ( '0' .. '9' )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// src\\unnamedLanguage.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTLIT"

	// $ANTLR start "FLOATLIT"
	public final void mFLOATLIT() throws RecognitionException {
		try {
			int _type = FLOATLIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:331:9: ( ( '0' .. '9' )+ '\\.' ( '0' .. '9' )+ )
			// src\\unnamedLanguage.g:331:11: ( '0' .. '9' )+ '\\.' ( '0' .. '9' )+
			{
			// src\\unnamedLanguage.g:331:11: ( '0' .. '9' )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// src\\unnamedLanguage.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			match('.'); 
			// src\\unnamedLanguage.g:331:28: ( '0' .. '9' )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// src\\unnamedLanguage.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOATLIT"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:334:4: ( ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' ) ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' | ( '0' .. '9' ) )* )
			// src\\unnamedLanguage.g:334:6: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' ) ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' | ( '0' .. '9' ) )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// src\\unnamedLanguage.g:334:33: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' | ( '0' .. '9' ) )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// src\\unnamedLanguage.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop6;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:341:9: ( ( '\\t' | ' ' | ( '\\r' | '\\n' ) )+ )
			// src\\unnamedLanguage.g:341:11: ( '\\t' | ' ' | ( '\\r' | '\\n' ) )+
			{
			// src\\unnamedLanguage.g:341:11: ( '\\t' | ' ' | ( '\\r' | '\\n' ) )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '\t' && LA7_0 <= '\n')||LA7_0=='\r'||LA7_0==' ') ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// src\\unnamedLanguage.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt7 >= 1 ) break loop7;
					EarlyExitException eee = new EarlyExitException(7, input);
					throw eee;
				}
				cnt7++;
			}

			 _channel = HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src\\unnamedLanguage.g:344:9: ( '//' (~ ( '\\r' | '\\n' ) )* ( '\\r' | '\\n' ) )
			// src\\unnamedLanguage.g:344:11: '//' (~ ( '\\r' | '\\n' ) )* ( '\\r' | '\\n' )
			{
			match("//"); 

			// src\\unnamedLanguage.g:344:16: (~ ( '\\r' | '\\n' ) )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= '\u0000' && LA8_0 <= '\t')||(LA8_0 >= '\u000B' && LA8_0 <= '\f')||(LA8_0 >= '\u000E' && LA8_0 <= '\uFFFF')) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// src\\unnamedLanguage.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop8;
				}
			}

			if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			 _channel = HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	@Override
	public void mTokens() throws RecognitionException {
		// src\\unnamedLanguage.g:1:8: ( OPENPAREN | CLOSEPAREN | OPENBRACE | CLOSEBRACE | OPENBRACKET | CLOSEBRACKET | SEMICOLON | COMMA | ASSIGNOP | EQUALITYOP | LESSTHANOP | ADDOP | SUBOP | MULTOP | IF | ELSE | WHILE | PRINT | PRINTLN | RETURN | STRTYPE | FLOATTYPE | CHARTYPE | INTTYPE | BOOLTYPE | VOIDTYPE | BOOLLIT | STRLIT | CHARLIT | INTLIT | FLOATLIT | ID | WS | COMMENT )
		int alt9=34;
		alt9 = dfa9.predict(input);
		switch (alt9) {
			case 1 :
				// src\\unnamedLanguage.g:1:10: OPENPAREN
				{
				mOPENPAREN(); 

				}
				break;
			case 2 :
				// src\\unnamedLanguage.g:1:20: CLOSEPAREN
				{
				mCLOSEPAREN(); 

				}
				break;
			case 3 :
				// src\\unnamedLanguage.g:1:31: OPENBRACE
				{
				mOPENBRACE(); 

				}
				break;
			case 4 :
				// src\\unnamedLanguage.g:1:41: CLOSEBRACE
				{
				mCLOSEBRACE(); 

				}
				break;
			case 5 :
				// src\\unnamedLanguage.g:1:52: OPENBRACKET
				{
				mOPENBRACKET(); 

				}
				break;
			case 6 :
				// src\\unnamedLanguage.g:1:64: CLOSEBRACKET
				{
				mCLOSEBRACKET(); 

				}
				break;
			case 7 :
				// src\\unnamedLanguage.g:1:77: SEMICOLON
				{
				mSEMICOLON(); 

				}
				break;
			case 8 :
				// src\\unnamedLanguage.g:1:87: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 9 :
				// src\\unnamedLanguage.g:1:93: ASSIGNOP
				{
				mASSIGNOP(); 

				}
				break;
			case 10 :
				// src\\unnamedLanguage.g:1:102: EQUALITYOP
				{
				mEQUALITYOP(); 

				}
				break;
			case 11 :
				// src\\unnamedLanguage.g:1:113: LESSTHANOP
				{
				mLESSTHANOP(); 

				}
				break;
			case 12 :
				// src\\unnamedLanguage.g:1:124: ADDOP
				{
				mADDOP(); 

				}
				break;
			case 13 :
				// src\\unnamedLanguage.g:1:130: SUBOP
				{
				mSUBOP(); 

				}
				break;
			case 14 :
				// src\\unnamedLanguage.g:1:136: MULTOP
				{
				mMULTOP(); 

				}
				break;
			case 15 :
				// src\\unnamedLanguage.g:1:143: IF
				{
				mIF(); 

				}
				break;
			case 16 :
				// src\\unnamedLanguage.g:1:146: ELSE
				{
				mELSE(); 

				}
				break;
			case 17 :
				// src\\unnamedLanguage.g:1:151: WHILE
				{
				mWHILE(); 

				}
				break;
			case 18 :
				// src\\unnamedLanguage.g:1:157: PRINT
				{
				mPRINT(); 

				}
				break;
			case 19 :
				// src\\unnamedLanguage.g:1:163: PRINTLN
				{
				mPRINTLN(); 

				}
				break;
			case 20 :
				// src\\unnamedLanguage.g:1:171: RETURN
				{
				mRETURN(); 

				}
				break;
			case 21 :
				// src\\unnamedLanguage.g:1:178: STRTYPE
				{
				mSTRTYPE(); 

				}
				break;
			case 22 :
				// src\\unnamedLanguage.g:1:186: FLOATTYPE
				{
				mFLOATTYPE(); 

				}
				break;
			case 23 :
				// src\\unnamedLanguage.g:1:196: CHARTYPE
				{
				mCHARTYPE(); 

				}
				break;
			case 24 :
				// src\\unnamedLanguage.g:1:205: INTTYPE
				{
				mINTTYPE(); 

				}
				break;
			case 25 :
				// src\\unnamedLanguage.g:1:213: BOOLTYPE
				{
				mBOOLTYPE(); 

				}
				break;
			case 26 :
				// src\\unnamedLanguage.g:1:222: VOIDTYPE
				{
				mVOIDTYPE(); 

				}
				break;
			case 27 :
				// src\\unnamedLanguage.g:1:231: BOOLLIT
				{
				mBOOLLIT(); 

				}
				break;
			case 28 :
				// src\\unnamedLanguage.g:1:239: STRLIT
				{
				mSTRLIT(); 

				}
				break;
			case 29 :
				// src\\unnamedLanguage.g:1:246: CHARLIT
				{
				mCHARLIT(); 

				}
				break;
			case 30 :
				// src\\unnamedLanguage.g:1:254: INTLIT
				{
				mINTLIT(); 

				}
				break;
			case 31 :
				// src\\unnamedLanguage.g:1:261: FLOATLIT
				{
				mFLOATLIT(); 

				}
				break;
			case 32 :
				// src\\unnamedLanguage.g:1:270: ID
				{
				mID(); 

				}
				break;
			case 33 :
				// src\\unnamedLanguage.g:1:273: WS
				{
				mWS(); 

				}
				break;
			case 34 :
				// src\\unnamedLanguage.g:1:276: COMMENT
				{
				mCOMMENT(); 

				}
				break;

		}
	}


	protected DFA9 dfa9 = new DFA9(this);
	static final String DFA9_eotS =
		"\11\uffff\1\40\4\uffff\13\34\2\uffff\1\56\5\uffff\1\60\14\34\3\uffff\1"+
		"\75\13\34\1\uffff\1\111\6\34\1\120\1\34\1\122\1\123\1\uffff\1\124\1\126"+
		"\2\34\1\131\1\123\1\uffff\1\34\3\uffff\1\34\1\uffff\1\134\1\135\1\uffff"+
		"\1\34\1\137\2\uffff\1\140\2\uffff";
	static final String DFA9_eofS =
		"\141\uffff";
	static final String DFA9_minS =
		"\1\11\10\uffff\1\75\4\uffff\1\146\1\154\1\150\1\162\1\145\1\164\1\141"+
		"\1\150\2\157\1\162\2\uffff\1\56\5\uffff\1\60\1\164\1\163\2\151\1\164\1"+
		"\162\1\157\1\154\1\141\1\157\1\151\1\165\3\uffff\1\60\1\145\1\154\1\156"+
		"\1\165\1\151\1\141\1\163\1\162\1\154\1\144\1\145\1\uffff\1\60\1\145\1"+
		"\164\1\162\1\156\1\164\1\145\1\60\1\145\2\60\1\uffff\2\60\1\156\1\147"+
		"\2\60\1\uffff\1\141\3\uffff\1\156\1\uffff\2\60\1\uffff\1\156\1\60\2\uffff"+
		"\1\60\2\uffff";
	static final String DFA9_maxS =
		"\1\175\10\uffff\1\75\4\uffff\1\156\1\154\1\150\1\162\1\145\1\164\1\154"+
		"\1\150\2\157\1\162\2\uffff\1\71\5\uffff\1\172\1\164\1\163\2\151\1\164"+
		"\1\162\1\157\1\154\1\141\1\157\1\151\1\165\3\uffff\1\172\1\145\1\154\1"+
		"\156\1\165\1\151\1\141\1\163\1\162\1\154\1\144\1\145\1\uffff\1\172\1\145"+
		"\1\164\1\162\1\156\1\164\1\145\1\172\1\145\2\172\1\uffff\2\172\1\156\1"+
		"\147\2\172\1\uffff\1\141\3\uffff\1\156\1\uffff\2\172\1\uffff\1\156\1\172"+
		"\2\uffff\1\172\2\uffff";
	static final String DFA9_acceptS =
		"\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\13\1\14\1\15\1\16"+
		"\13\uffff\1\34\1\35\1\uffff\1\40\1\41\1\42\1\12\1\11\15\uffff\1\36\1\37"+
		"\1\17\14\uffff\1\30\13\uffff\1\20\6\uffff\1\27\1\uffff\1\32\1\33\1\21"+
		"\1\uffff\1\22\2\uffff\1\26\2\uffff\1\24\1\25\1\uffff\1\23\1\31";
	static final String DFA9_specialS =
		"\141\uffff}>";
	static final String[] DFA9_transitionS = {
			"\2\35\2\uffff\1\35\22\uffff\1\35\1\uffff\1\31\4\uffff\1\32\1\1\1\2\1"+
			"\15\1\13\1\10\1\14\1\uffff\1\36\12\33\1\uffff\1\7\1\12\1\11\3\uffff\32"+
			"\34\1\5\1\uffff\1\6\1\uffff\1\34\1\uffff\1\34\1\26\1\25\1\34\1\17\1\24"+
			"\2\34\1\16\6\34\1\21\1\34\1\22\1\23\1\30\1\34\1\27\1\20\3\34\1\3\1\uffff"+
			"\1\4",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\37",
			"",
			"",
			"",
			"",
			"\1\41\7\uffff\1\42",
			"\1\43",
			"\1\44",
			"\1\45",
			"\1\46",
			"\1\47",
			"\1\51\12\uffff\1\50",
			"\1\52",
			"\1\53",
			"\1\54",
			"\1\55",
			"",
			"",
			"\1\57\1\uffff\12\33",
			"",
			"",
			"",
			"",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\61",
			"\1\62",
			"\1\63",
			"\1\64",
			"\1\65",
			"\1\66",
			"\1\67",
			"\1\70",
			"\1\71",
			"\1\72",
			"\1\73",
			"\1\74",
			"",
			"",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\76",
			"\1\77",
			"\1\100",
			"\1\101",
			"\1\102",
			"\1\103",
			"\1\104",
			"\1\105",
			"\1\106",
			"\1\107",
			"\1\110",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\112",
			"\1\113",
			"\1\114",
			"\1\115",
			"\1\116",
			"\1\117",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\121",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\13\34\1\125\16\34",
			"\1\127",
			"\1\130",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"\1\132",
			"",
			"",
			"",
			"\1\133",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"\1\136",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			""
	};

	static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
	static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
	static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
	static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
	static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
	static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
	static final short[][] DFA9_transition;

	static {
		int numStates = DFA9_transitionS.length;
		DFA9_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
		}
	}

	protected class DFA9 extends DFA {

		public DFA9(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 9;
			this.eot = DFA9_eot;
			this.eof = DFA9_eof;
			this.min = DFA9_min;
			this.max = DFA9_max;
			this.accept = DFA9_accept;
			this.special = DFA9_special;
			this.transition = DFA9_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( OPENPAREN | CLOSEPAREN | OPENBRACE | CLOSEBRACE | OPENBRACKET | CLOSEBRACKET | SEMICOLON | COMMA | ASSIGNOP | EQUALITYOP | LESSTHANOP | ADDOP | SUBOP | MULTOP | IF | ELSE | WHILE | PRINT | PRINTLN | RETURN | STRTYPE | FLOATTYPE | CHARTYPE | INTTYPE | BOOLTYPE | VOIDTYPE | BOOLLIT | STRLIT | CHARLIT | INTLIT | FLOATLIT | ID | WS | COMMENT );";
		}
	}

}
