.source factorial.ir
.class public factorial
.super java/lang/Object

.method public static factorial(I)I
        .limit locals 10
        .var 0 is T0  I from L_0 to L_1
        .var 1 is T1  I from L_0 to L_1
        .var 2 is T2  I from L_0 to L_1
        .var 3 is T3  Z from L_0 to L_1
        .var 4 is T4  Z from L_0 to L_1
        .var 5 is T5  I from L_0 to L_1
        .var 6 is T6  I from L_0 to L_1
        .var 7 is T7  I from L_0 to L_1
        .var 8 is T8  I from L_0 to L_1
        .var 9 is T9  I from L_0 to L_1
        .limit stack 16
L_0:
        ldc 0
        istore 1
        ldc 0
        istore 2
        ldc 0
        istore 3
        ldc 0
        istore 4
        ldc 0
        istore 5
        ldc 0
        istore 6
        ldc 0
        istore 7
        ldc 0
        istore 8
        ldc 0
        istore 9
.line 14
;                   T2 := 1;
        ldc 1
        istore 2
.line 15
;                   T3 := T0 I== T2;
        iload 0
        iload 2
        isub
        ifeq L_2
        ldc 0
        goto L_3
L_2:
        ldc 1
L_3:
        istore 3
.line 16
;                   T4 := Z! T3;
        iload 3
        ldc 1
        ixor
        istore 4
.line 17
;                   IF T4 GOTO L0;
        iload 4
        ifne L0
.line 18
;                   T5 := 1;
        ldc 1
        istore 5
.line 19
;                   T1 := T5;
        iload 5
        istore 1
.line 20
;                   GOTO L1;
        goto L1
.line 21
;                   L0:;
L0:
.line 22
;                   T7 := 1;
        ldc 1
        istore 7
.line 23
;                   T8 := T0 I- T7;
        iload 0
        iload 7
        isub
        istore 8
.line 24
;                   T6 := CALL factorial(T8);
        iload 8
        invokestatic factorial/factorial(I)I
        istore 6
.line 25
;                   T9 := T0 I* T6;
        iload 0
        iload 6
        imul
        istore 9
.line 26
;                   T1 := T9;
        iload 9
        istore 1
.line 27
;                   L1:;
L1:
.line 28
;                   RETURN T1;
        iload 1
        ireturn
L_1:
.end method

.method public static __main()V
        .limit locals 3
        .var 0 is T0  Ljava/lang/String; from L_8 to L_9
        .var 1 is T1  I from L_8 to L_9
        .var 2 is T2  I from L_8 to L_9
        .limit stack 16
L_8:
        aconst_null
        astore 0
        ldc 0
        istore 1
        ldc 0
        istore 2
.line 36
;                   T0 := "The factorial of 9 is ";
        ldc "The factorial of 9 is "
        astore 0
.line 37
;                   PRINTU T0;
        getstatic java/lang/System/out Ljava/io/PrintStream;
        aload 0
        invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
.line 38
;                   T2 := 9;
        ldc 9
        istore 2
.line 39
;                   T1 := CALL factorial(T2);
        iload 2
        invokestatic factorial/factorial(I)I
        istore 1
.line 40
;                   PRINTLNI T1;
        getstatic java/lang/System/out Ljava/io/PrintStream;
        iload 1
        invokevirtual java/io/PrintStream/println(I)V
.line 41
;                   RETURN;
        return
L_9:
.end method

;--------------------------------------------;
;                                            ;
; Boilerplate                                ;
;                                            ;
;--------------------------------------------;

.method public static main([Ljava/lang/String;)V
        ; set limits used by this method
        .limit locals 1
        .limit stack 4
        invokestatic factorial/__main()V
        return
.end method

; standard initializer
.method public <init>()V
        aload_0
        invokenonvirtual java/lang/Object/<init>()V
        return
.end method