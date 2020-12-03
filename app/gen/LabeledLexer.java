// Generated from D:/learnWork/zpzookeeper/app/src/main/resources\Labeled.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LabeledLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, MUL=7, DIV=8, ADD=9, SUB=10, 
		AND=11, ID=12, NUM=13, WS=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "MUL", "DIV", "ADD", 
			"SUB", "AND", "ID", "NUM", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'('", "')'", "'['", "','", "']'", "'*'", "'/'", "'+'", 
			"'-'", "'#'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "MUL", "DIV", "ADD", "SUB", 
			"AND", "ID", "NUM", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public LabeledLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Labeled.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20l\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\6\r\67"+
		"\n\r\r\r\16\r8\3\r\3\r\6\r=\n\r\r\r\16\r>\3\16\6\16B\n\16\r\16\16\16C"+
		"\3\16\3\16\3\16\6\16I\n\16\r\16\16\16J\3\16\3\16\6\16O\n\16\r\16\16\16"+
		"P\3\16\3\16\6\16U\n\16\r\16\16\16V\3\16\3\16\3\16\6\16\\\n\16\r\16\16"+
		"\16]\3\16\3\16\6\16b\n\16\r\16\16\16c\3\16\5\16g\n\16\3\17\3\17\3\17\3"+
		"\17\2\2\20\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\3\2\6\4\2C\\c|\5\2\62;C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2v\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\3\37\3\2\2\2\5!\3\2\2\2\7#\3\2\2"+
		"\2\t%\3\2\2\2\13\'\3\2\2\2\r)\3\2\2\2\17+\3\2\2\2\21-\3\2\2\2\23/\3\2"+
		"\2\2\25\61\3\2\2\2\27\63\3\2\2\2\31\66\3\2\2\2\33f\3\2\2\2\35h\3\2\2\2"+
		"\37 \7?\2\2 \4\3\2\2\2!\"\7*\2\2\"\6\3\2\2\2#$\7+\2\2$\b\3\2\2\2%&\7]"+
		"\2\2&\n\3\2\2\2\'(\7.\2\2(\f\3\2\2\2)*\7_\2\2*\16\3\2\2\2+,\7,\2\2,\20"+
		"\3\2\2\2-.\7\61\2\2.\22\3\2\2\2/\60\7-\2\2\60\24\3\2\2\2\61\62\7/\2\2"+
		"\62\26\3\2\2\2\63\64\7%\2\2\64\30\3\2\2\2\65\67\t\2\2\2\66\65\3\2\2\2"+
		"\678\3\2\2\28\66\3\2\2\289\3\2\2\29:\3\2\2\2:<\7\60\2\2;=\t\3\2\2<;\3"+
		"\2\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2\2?\32\3\2\2\2@B\t\4\2\2A@\3\2\2\2B"+
		"C\3\2\2\2CA\3\2\2\2CD\3\2\2\2Dg\3\2\2\2EF\7*\2\2FH\7/\2\2GI\t\4\2\2HG"+
		"\3\2\2\2IJ\3\2\2\2JH\3\2\2\2JK\3\2\2\2KL\3\2\2\2Lg\7+\2\2MO\t\4\2\2NM"+
		"\3\2\2\2OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QR\3\2\2\2RT\7\60\2\2SU\t\4\2\2"+
		"TS\3\2\2\2UV\3\2\2\2VT\3\2\2\2VW\3\2\2\2Wg\3\2\2\2XY\7*\2\2Y[\7/\2\2Z"+
		"\\\t\4\2\2[Z\3\2\2\2\\]\3\2\2\2][\3\2\2\2]^\3\2\2\2^_\3\2\2\2_a\7\60\2"+
		"\2`b\t\4\2\2a`\3\2\2\2bc\3\2\2\2ca\3\2\2\2cd\3\2\2\2de\3\2\2\2eg\7+\2"+
		"\2fA\3\2\2\2fE\3\2\2\2fN\3\2\2\2fX\3\2\2\2g\34\3\2\2\2hi\t\5\2\2ij\3\2"+
		"\2\2jk\b\17\2\2k\36\3\2\2\2\f\28>CJPV]cf\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}