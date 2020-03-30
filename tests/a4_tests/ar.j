.class public ar
.super java/lang/Object

.method public static __main()V
    .limit locals 18
    .limit stack 50
;       T0 := NEWARRAY I 3
    ldc 3
    newarray int
    astore 0
;       T3 := 0
    ldc 0
    istore 3
;       T4 := 7
    ldc 7
    istore 4
;       T0[T3] := T4
    aload 0
    iload 3
    iload 4
    iastore
;       T5 := 1
    ldc 1
    istore 5
;       T6 := 24
    ldc 24
    istore 6
;       T0[T5] := T6
    aload 0
    iload 5
    iload 6
    iastore
;       T7 := 1
    ldc 1
    istore 7
;       T1 := T7
    iload 7
    istore 1
;       T8 := 1
    ldc 1
    istore 8
;       T9 := T1 I+ T8
    iload 1
    iload 8
    iadd
    istore 9
;       T10 := 2
    ldc 2
    istore 10
;       T0[T9] := T10
    aload 0
    iload 9
    iload 10
    iastore
;       T11 := 0
    ldc 0
    istore 11
;       T2 := T11
    iload 11
    istore 2
;       L0:
L0:
;       T12 := 3
    ldc 3
    istore 12
;       T13 := T2 I< T12
    iload 2
    iload 12
    isub
    iflt L_0
    ldc 0
    goto L_1
L_0:
    ldc 1
L_1:
    istore 13
;       T14 := Z! T13
    iload 13
    ifne L_2
    iconst_1
    goto L_3
L_2:
    iconst_0
L_3:
    istore 14
;       IF T14 GOTO L1
    iload 14
    ifne L1
;       T15 := T0[T2]
    aload 0
    iload 2
    iaload
    istore 15
;       PRINTLNI T15
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 15
    invokevirtual java/io/PrintStream/println(I)V
;       T16 := 1
    ldc 1
    istore 16
;       T17 := T2 I+ T16
    iload 2
    iload 16
    iadd
    istore 17
;       T2 := T17
    iload 17
    istore 2
;       GOTO L0
    goto L0
;       L1:
L1:
    return
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