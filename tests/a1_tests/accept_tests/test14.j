.class public test14
.super java/lang/Object

.method public static random_int(I)I
    .limit locals 10
    .limit stack 50
;       T1 := 3
    ldc 3
    istore 1
;       T2 := T0 I* T1
    iload 0
    iload 1
    imul
    istore 2
;       T3 := 234
    ldc 234
    istore 3
;       T4 := T2 I+ T3
    iload 2
    iload 3
    iadd
    istore 4
;       T5 := T0 I* T0
    iload 0
    iload 0
    imul
    istore 5
;       T6 := T4 I- T5
    iload 4
    iload 5
    isub
    istore 6
;       T7 := T0 I* T0
    iload 0
    iload 0
    imul
    istore 7
;       T8 := T7 I* T0
    iload 7
    iload 0
    imul
    istore 8
;       T9 := T6 I+ T8
    iload 6
    iload 8
    iadd
    istore 9
;       RETURN T9
    iload 9
    ireturn
.end method


.method public static sort([I)[I
    .limit locals 38
    .limit stack 50
;       T2 := 1
    ldc 1
    istore 2
;       T3 := T0[T2]
    aload 0
    iload 2
    iaload
    istore 3
;       T4 := 0
    ldc 0
    istore 4
;       T5 := T0[T4]
    aload 0
    iload 4
    iaload
    istore 5
;       T6 := T3 I< T5
    iload 3
    iload 5
    isub
    iflt L_0
    ldc 0
    goto L_1
L_0:
    ldc 1
L_1:
    istore 6
;       T7 := Z! T6
    iload 6
    ifne L_2
    iconst_1
    goto L_3
L_2:
    iconst_0
L_3:
    istore 7
;       IF T7 GOTO L0
    iload 7
    ifne L0
;       T8 := 1
    ldc 1
    istore 8
;       T9 := T0[T8]
    aload 0
    iload 8
    iaload
    istore 9
;       T1 := T9
    iload 9
    istore 1
;       T10 := 1
    ldc 1
    istore 10
;       T11 := 0
    ldc 0
    istore 11
;       T12 := T0[T11]
    aload 0
    iload 11
    iaload
    istore 12
;       T0[T10] := T12
    aload 0
    iload 10
    iload 12
    iastore
;       T13 := 0
    ldc 0
    istore 13
;       T0[T13] := T1
    aload 0
    iload 13
    iload 1
    iastore
;       L0:
L0:
;       T14 := 2
    ldc 2
    istore 14
;       T15 := T0[T14]
    aload 0
    iload 14
    iaload
    istore 15
;       T16 := 1
    ldc 1
    istore 16
;       T17 := T0[T16]
    aload 0
    iload 16
    iaload
    istore 17
;       T18 := T15 I< T17
    iload 15
    iload 17
    isub
    iflt L_4
    ldc 0
    goto L_5
L_4:
    ldc 1
L_5:
    istore 18
;       T19 := Z! T18
    iload 18
    ifne L_6
    iconst_1
    goto L_7
L_6:
    iconst_0
L_7:
    istore 19
;       IF T19 GOTO L1
    iload 19
    ifne L1
;       T20 := 2
    ldc 2
    istore 20
;       T21 := T0[T20]
    aload 0
    iload 20
    iaload
    istore 21
;       T1 := T21
    iload 21
    istore 1
;       T22 := 2
    ldc 2
    istore 22
;       T23 := 1
    ldc 1
    istore 23
;       T24 := T0[T23]
    aload 0
    iload 23
    iaload
    istore 24
;       T0[T22] := T24
    aload 0
    iload 22
    iload 24
    iastore
;       T25 := 1
    ldc 1
    istore 25
;       T0[T25] := T1
    aload 0
    iload 25
    iload 1
    iastore
;       L1:
L1:
;       T26 := 1
    ldc 1
    istore 26
;       T27 := T0[T26]
    aload 0
    iload 26
    iaload
    istore 27
;       T28 := 0
    ldc 0
    istore 28
;       T29 := T0[T28]
    aload 0
    iload 28
    iaload
    istore 29
;       T30 := T27 I< T29
    iload 27
    iload 29
    isub
    iflt L_8
    ldc 0
    goto L_9
L_8:
    ldc 1
L_9:
    istore 30
;       T31 := Z! T30
    iload 30
    ifne L_10
    iconst_1
    goto L_11
L_10:
    iconst_0
L_11:
    istore 31
;       IF T31 GOTO L2
    iload 31
    ifne L2
;       T32 := 1
    ldc 1
    istore 32
;       T33 := T0[T32]
    aload 0
    iload 32
    iaload
    istore 33
;       T1 := T33
    iload 33
    istore 1
;       T34 := 1
    ldc 1
    istore 34
;       T35 := 0
    ldc 0
    istore 35
;       T36 := T0[T35]
    aload 0
    iload 35
    iaload
    istore 36
;       T0[T34] := T36
    aload 0
    iload 34
    iload 36
    iastore
;       T37 := 0
    ldc 0
    istore 37
;       T0[T37] := T1
    aload 0
    iload 37
    iload 1
    iastore
;       L2:
L2:
;       RETURN T0
    aload 0
    areturn
.end method


.method public static __main()V
    .limit locals 26
    .limit stack 50
;       T10 := NEWARRAY I 3
    ldc 3
    newarray int
    astore 10
;       T12 := 3
    ldc 3
    istore 12
;       T11 := CALL random_int(T12)
    iload 12
    invokestatic test14/random_int(I)I
    istore 11
;       T0 := T11
    iload 11
    istore 0
;       T14 := 34
    ldc 34
    istore 14
;       T13 := CALL random_int(T14)
    iload 14
    invokestatic test14/random_int(I)I
    istore 13
;       T1 := T13
    iload 13
    istore 1
;       T16 := 2
    ldc 2
    istore 16
;       T15 := CALL random_int(T16)
    iload 16
    invokestatic test14/random_int(I)I
    istore 15
;       T2 := T15
    iload 15
    istore 2
;       T17 := 0
    ldc 0
    istore 17
;       T10[T17] := T0
    aload 10
    iload 17
    iload 0
    iastore
;       T18 := 1
    ldc 1
    istore 18
;       T10[T18] := T1
    aload 10
    iload 18
    iload 1
    iastore
;       T19 := 2
    ldc 2
    istore 19
;       T10[T19] := T2
    aload 10
    iload 19
    iload 2
    iastore
;       T20 := CALL sort(T10)
    aload 10
    invokestatic test14/sort([I)[I
    astore 20
;       T10 := T20
    aload 20
    astore 10
;       T21 := 0
    ldc 0
    istore 21
;       T3 := T21
    iload 21
    istore 3
;       L0:
L0:
;       T22 := 3
    ldc 3
    istore 22
;       T23 := T3 I< T22
    iload 3
    iload 22
    isub
    iflt L_12
    ldc 0
    goto L_13
L_12:
    ldc 1
L_13:
    istore 23
;       T24 := Z! T23
    iload 23
    ifne L_14
    iconst_1
    goto L_15
L_14:
    iconst_0
L_15:
    istore 24
;       IF T24 GOTO L1
    iload 24
    ifne L1
;       T25 := T10[T3]
    aload 10
    iload 3
    iaload
    istore 25
;       PRINTLNI T25
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 25
    invokevirtual java/io/PrintStream/println(I)V
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
    invokestatic test14/__main()V
    return
.end method

; standard initializer
.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method