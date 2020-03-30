.source expr.ir
.class public expr
.super java/lang/Object

.method public static __main()V
        .limit locals 11
        .var 0 is T0  I from L_0 to L_1
        .var 1 is T1  I from L_0 to L_1
        .var 2 is T2  I from L_0 to L_1
        .var 3 is T3  I from L_0 to L_1
        .var 4 is T4  I from L_0 to L_1
        .var 5 is T5  I from L_0 to L_1
        .var 6 is T6  I from L_0 to L_1
        .var 7 is T7  I from L_0 to L_1
        .var 8 is T8  I from L_0 to L_1
        .var 9 is T9  I from L_0 to L_1
        .var 10 is T10  I from L_0 to L_1
        .limit stack 16
L_0:
        ldc 0
        istore 0
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
        ldc 0
        istore 10
.line 15
;                   T3 := 1;
        ldc 1
        istore 3
.line 16
;                   T0 := T3;
        iload 3
        istore 0
.line 17
;                   T4 := 2;
        ldc 2
        istore 4
.line 18
;                   T1 := T4;
        iload 4
        istore 1
.line 19
;                   T5 := 3;
        ldc 3
        istore 5
.line 20
;                   T2 := T5;
        iload 5
        istore 2
.line 21
;                   T6 := 1;
        ldc 1
        istore 6
.line 22
;                   T7 := T1 I+ T6;
        iload 1
        iload 6
        iadd
        istore 7
.line 23
;                   T8 := T0 I* T7;
        iload 0
        iload 7
        imul
        istore 8
.line 24
;                   T9 := 7;
        ldc 7
        istore 9
.line 25
;                   T10 := T8 I+ T9;
        iload 8
        iload 9
        iadd
        istore 10
.line 26
;                   T2 := T10;
        iload 10
        istore 2
.line 27
;                   PRINTLNI T2;
        getstatic java/lang/System/out Ljava/io/PrintStream;
        iload 2
        invokevirtual java/io/PrintStream/println(I)V
.line 28
;                   RETURN;
        return
L_1:
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
        invokestatic expr/__main()V
        return
.end method

; standard initializer
.method public <init>()V
        aload_0
        invokenonvirtual java/lang/Object/<init>()V
        return
.end method