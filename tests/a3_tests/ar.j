.source ar.ir
.class public ar
.super java/lang/Object

.method public static __main()V
        .limit locals 18
        .var 0 is T0  [I from L_0 to L_1
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
        .var 11 is T11  I from L_0 to L_1
        .var 12 is T12  I from L_0 to L_1
        .var 13 is T13  Z from L_0 to L_1
        .var 14 is T14  Z from L_0 to L_1
        .var 15 is T15  I from L_0 to L_1
        .var 16 is T16  I from L_0 to L_1
        .var 17 is T17  I from L_0 to L_1
        .limit stack 16
L_0:
        aconst_null
        astore 0
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
        ldc 0
        istore 11
        ldc 0
        istore 12
        ldc 0
        istore 13
        ldc 0
        istore 14
        ldc 0
        istore 15
        ldc 0
        istore 16
        ldc 0
        istore 17
.line 22
;                   T0 := NEWARRAY I 3;
        ldc 3
        newarray int
        astore 0
.line 23
;                   T3 := 0;
        ldc 0
        istore 3
.line 24
;                   T4 := 7;
        ldc 7
        istore 4
.line 25
;                   T0[T3] := T4;
        aload 0
        iload 3
        iload 4
        iastore
.line 26
;                   T5 := 1;
        ldc 1
        istore 5
.line 27
;                   T6 := 24;
        ldc 24
        istore 6
.line 28
;                   T0[T5] := T6;
        aload 0
        iload 5
        iload 6
        iastore
.line 29
;                   T7 := 1;
        ldc 1
        istore 7
.line 30
;                   T1 := T7;
        iload 7
        istore 1
.line 31
;                   T8 := 1;
        ldc 1
        istore 8
.line 32
;                   T9 := T1 I+ T8;
        iload 1
        iload 8
        iadd
        istore 9
.line 33
;                   T10 := 2;
        ldc 2
        istore 10
.line 34
;                   T0[T9] := T10;
        aload 0
        iload 9
        iload 10
        iastore
.line 35
;                   T11 := 0;
        ldc 0
        istore 11
.line 36
;                   T2 := T11;
        iload 11
        istore 2
.line 37
;                   L0:;
L0:
.line 38
;                   T12 := 3;
        ldc 3
        istore 12
.line 39
;                   T13 := T2 I< T12;
        iload 2
        iload 12
        isub
        iflt L_4
        ldc 0
        goto L_5
L_4:
        ldc 1
L_5:
        istore 13
.line 40
;                   T14 := Z! T13;
        iload 13
        ldc 1
        ixor
        istore 14
.line 41
;                   IF T14 GOTO L1;
        iload 14
        ifne L1
.line 42
;                   T15 := T0[T2];
        aload 0
        iload 2
        iaload
        istore 15
.line 43
;                   PRINTLNI T15;
        getstatic java/lang/System/out Ljava/io/PrintStream;
        iload 15
        invokevirtual java/io/PrintStream/println(I)V
.line 44
;                   T16 := 1;
        ldc 1
        istore 16
.line 45
;                   T17 := T2 I+ T16;
        iload 2
        iload 16
        iadd
        istore 17
.line 46
;                   T2 := T17;
        iload 17
        istore 2
.line 47
;                   GOTO L0;
        goto L0
.line 48
;                   L1:;
L1:
.line 49
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
        invokestatic ar/__main()V
        return
.end method

; standard initializer
.method public <init>()V
        aload_0
        invokenonvirtual java/lang/Object/<init>()V
        return
.end method